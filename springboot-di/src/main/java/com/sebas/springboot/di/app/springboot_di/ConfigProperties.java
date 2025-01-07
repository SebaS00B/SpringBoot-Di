package com.sebas.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

import com.sebas.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
    @PropertySource("classpath:config.properties")
})
public class ConfigProperties {

    @Value("classpath:json/product.json")
    private Resource resource;
    
    @Bean("productJson")
    ProductRepositoryJson productRepositoryJson() {
        return new ProductRepositoryJson(resource);

        }
}
