package com.hiberus.dual.crud.controllers;

import com.hiberus.dual.crud.services.ICartsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * CartController
 */
@Controller
public class CartController {
    // private ProductsService productsService = new ProductsService();
    private ICartsService cartService;

    @Autowired
    public CartController(ICartsService cartService) {
        this.cartService = cartService;
    }

    // @GetMapping({ "cart" })
    // public String cart(Model model) {
    //     model.addAttribute("products", cartService.getProducts());
    //     return "cart";
    // }

    // @PostMapping({ "/cart/addProduct" })
    // public String addProduct(@ModelAttribute("Product") Product product) {
    //     cartService.addProduct(product);
    //     System.out.println(cartService.getProducts());
    //     return "redirect:/products";
    // }

    // @PostMapping({ "/cart/deleteProduct" })
    // public String deleteProduct(@ModelAttribute("Product") Product product) {
    //     cartService.deleteProduct(product);
    //     System.out.println(cartService.getProducts());
    //     return "redirect:/cart";
    // }
}