package com.project.solinium.impl.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import com.project.solinium.services.ProductsServ;

import lombok.RequiredArgsConstructor;
import com.project.solinium.model.Products;
import com.project.solinium.repository.ProductsRepo;

@Service
@RequiredArgsConstructor // for do the dependecy injection
public class ProductsServImpl implements ProductsServ{

    private final ProductsRepo productsRepo;

    @Override
    public List<Products> findAllProducts(){
        return productsRepo.findAll();
    }

    @Override
    public Products insertProduct(Products products){
        return productsRepo.save(products);
    }
    
}
