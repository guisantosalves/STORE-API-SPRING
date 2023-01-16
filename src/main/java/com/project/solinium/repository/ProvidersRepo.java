package com.project.solinium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solinium.model.Providers;

@Repository
public interface ProvidersRepo extends JpaRepository<Providers, Integer>{
    
}
