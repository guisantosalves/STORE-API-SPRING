package com.project.solinium.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solinium.model.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer>{
    Optional<Products> findBycod(String cod);
}
