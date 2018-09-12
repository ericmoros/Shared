package com.hiberus.dual.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hiberus.dual.crud.models.Product;
import com.hiberus.dual.crud.repositories.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductsService
 */
@Service
public class ProductsService implements IProductsService {
    // Atts
    private ProductsRepository productsRepository;

    //Ctor
    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //Methods
    @Override
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        productsRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getProduct(Long id) {
        Product product = null;
        Optional<Product> oproduct;
        oproduct = productsRepository.findById(id);
        if (oproduct.isPresent())
            product = oproduct.get();
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public void populateProducts() {
        productsRepository.saveAll(PRODUCTS);
    }

    @Override
    public void deleteProducts() {
        productsRepository.deleteAll();
    }

    @Override
    public void addProduct(Product product) {
        productsRepository.save(product);
    }

    @Override
    public void editProduct(Product product) {
        productsRepository.save(product);
    }

}