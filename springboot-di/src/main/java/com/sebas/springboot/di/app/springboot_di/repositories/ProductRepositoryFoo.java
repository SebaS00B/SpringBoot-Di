package com.sebas.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.sebas.springboot.di.app.springboot_di.models.Product;


@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor ASUS 27p", 500L));

    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor ASUS 27p", 500L);
        
    }

}
