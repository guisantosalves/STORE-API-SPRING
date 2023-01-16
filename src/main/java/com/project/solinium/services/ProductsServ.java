package com.project.solinium.services;

import java.util.List;

import com.project.solinium.model.Products;

public interface ProductsServ {
    List<Products> findAllProducts();

    Products findProductById(Integer id);

    Products insertProduct(Products products);

    Products deleteProductById(Integer id);

    Products updatingById(Integer id, Products products);
}
