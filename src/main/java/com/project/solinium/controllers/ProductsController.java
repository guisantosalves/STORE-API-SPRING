package com.project.solinium.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.solinium.services.ProductsServ;
import com.project.solinium.model.Products;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final ProductsServ productsServ;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Products>> getAllProducts(){
        return new ResponseEntity<List<Products>>(productsServ.findAllProducts(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Products> creatingProduct(@RequestBody Products products){
        return new ResponseEntity<Products>(productsServ.insertProduct(products), HttpStatus.OK);
    }

    @RequestMapping(path = "{productId}", method = RequestMethod.DELETE)
    public void deletingProduct(@PathVariable("productId") Integer id){
        productsServ.deleteProductById(id);
    }
}
