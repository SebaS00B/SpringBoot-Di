package com.sebas.springboot.di.app.springboot_di.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sebas.springboot.di.app.springboot_di.models.Product;
import com.sebas.springboot.di.app.springboot_di.repositories.ProductRepository;


@Service
public class ProductServicesImpl implements ProductServices {

    @Value("${config.taxes}")
    private Double tax;
   
    private ProductRepository repository;

    public ProductServicesImpl(@Qualifier("productJson") ProductRepository repository) {
            this.repository = repository;
    }

    @Override
    
    public List<Product> findAll() {
        return repository.findAll().stream().map(p->{
            Double priceTax = p.getPrice()* tax;
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
        }
    }
