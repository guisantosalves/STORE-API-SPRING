package com.project.solinium.impl.services;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.project.solinium.services.ProductsServ;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import com.fasterxml.jackson.core.format.DataFormatDetector;
import com.project.solinium.model.Products;
import com.project.solinium.repository.ProductsRepo;

@Service
@RequiredArgsConstructor // for do the dependecy injection
public class ProductsServImpl implements ProductsServ {

    private final ProductsRepo productsRepo;

    @Override
    public List<Products> findAllProducts() {
        return productsRepo.findAll();
    }

    @Override
    public Products findProductById(Integer id) {
        return productsRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("id does not exist!!"));
    }

    @Override
    public Products insertProduct(Products products) {
        Optional<Products> dataFromDb = productsRepo.findBycod(products.getCod());
        
        if(dataFromDb.isPresent()){
            throw new IllegalStateException("Code can not repeat!");
        }

        // if realy the code does not exist in any registry
        return productsRepo.save(products);
    }

    @Override
    public Products deleteProductById(Integer id) {
        Products verifyingProduct = productsRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Id does not exist!!"));

        if (verifyingProduct != null) {
            productsRepo.deleteById(id);
        }

        return verifyingProduct;
    }

    @Override
    @Transactional
    public Products updatingById(Integer id, Products products) {
        Products dataFromDB = productsRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Id does not exist"));

        Optional<Products> verifyingCode = productsRepo.findBycod(products.getCod());  

        // updating
        if (products.getProduct() == null || products.getProduct().length() < 1) throw new IllegalStateException("Product needs a name");
        dataFromDB.setProduct(products.getProduct());

        // just insert if it has something
        if (products.getDescription() != null) {
            dataFromDB.setDescription(products.getDescription());
        }

        if (products.getValue() == null || products.getValue() < 1) {
            throw new IllegalStateException("Value needs to be inserted");
        }
        dataFromDB.setValue(products.getValue());


        if(verifyingCode.isPresent()) throw new IllegalStateException("Code can not repeat");
        if(products.getCod() != null){
            dataFromDB.setCod(products.getCod());
        }else{
            dataFromDB.setCod(dataFromDB.getCod());
        }

        return dataFromDB;
    }
}
