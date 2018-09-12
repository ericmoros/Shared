package com.hiberus.dual.crud.controllers;

import com.hiberus.dual.crud.models.Product;
import com.hiberus.dual.crud.services.IProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Data;

/**
 * ProductsController
 */
@Controller
@Data
public class ProductsController {
    private IProductsService productsService;

    @Autowired
    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping({ "/products" })
    public String products(Model model) {
        model.addAttribute("products", productsService.getProducts());
        return "products";
    }

    @GetMapping({"/products/populate"})
    public String populateProducts() {
        productsService.populateProducts();
        return "redirect:/products";
    }

    @GetMapping({"/products/delete/{id}"})
    public String deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping({"/products/delete/all"})
    public String deleteProducts() {
        productsService.deleteProducts();
        return "redirect:/products";
    }

    @PostMapping({"/products/edit"})
    public String editProduct(@ModelAttribute("Product") Product product) {
        productsService.editProduct(product);
        return "redirect:/products";
    }

    @PostMapping({"/products/calculateTotalPrice"})
    public String calculateTotalPrice() {
        productsService.calculateTotalPrice();
        return "redirect:/products";
    }
}