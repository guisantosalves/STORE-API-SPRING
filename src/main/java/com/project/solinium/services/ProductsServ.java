package com.project.solinium.services;

import java.util.List;

import com.project.solinium.model.Products;

public interface ProductsServ {
    List<Products> findAllProducts();

    Products insertProduct(Products products);

    void deleteProductById(Integer id);
}
