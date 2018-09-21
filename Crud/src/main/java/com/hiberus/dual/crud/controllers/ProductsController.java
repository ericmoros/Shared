package com.hiberus.dual.crud.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.hiberus.dual.crud.models.Product;
import com.hiberus.dual.crud.services.IProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;

/**
 * ProductsController
 */
@Controller
@Data
@RequestMapping("/products")
public class ProductsController {

    private static int currentPage = 1;
    private static int pageSize = 6;

    private IProductsService productsService;

    @Autowired
    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
    }

    // @GetMapping
    // public String products(Model model) {
    //    model.addAttribute("products", productsService.getProducts());
    //    return "products";
    // }

    @GetMapping({"/populate"})
    public String populateProducts() {
        productsService.populateProducts();
        return "redirect:/products";
    }

    @GetMapping({"/delete/{id}"})
    public String deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping({"/delete/all"})
    public String deleteProducts() {
        productsService.deleteProducts();
        return "redirect:/products";
    }

    @PostMapping({"/edit"})
    public String editProduct(@ModelAttribute("Product") Product products) {
        productsService.editProduct(products);
        return "redirect:/products";
    }

    @GetMapping({"/update/total-price"})
    public String updateTotalPrice() {
        productsService.updateTotalPrice();
        return "redirect:/products";
    }

    @PostMapping({"/add"})
    public String productAdd(@ModelAttribute("Product") Product products) {
        productsService.addProduct(products);
        return "redirect:/products";
    }

    @GetMapping
    public String listproducts(
        Model model, 
        @RequestParam("page") Optional<Integer> page, 
        @RequestParam("size") Optional<Integer> size) {
        page.ifPresent(p -> currentPage = p);
        size.ifPresent(s -> pageSize = s);
 
        Page<Product> productsPage = productsService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
 
        model.addAttribute("products", productsPage);
 
        int totalPages = productsPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "products";
    }
}