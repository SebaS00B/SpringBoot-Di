package com.sebas.springboot.di.app.springboot_di.services;

import java.util.List;

import com.sebas.springboot.di.app.springboot_di.models.Product;

public interface ProductServices {
    List <Product> findAll();
    Product findById(Long id);
}
