package com.hiberus.dual.crud.controllers;

import com.hiberus.dual.crud.services.ICartsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CartsController
 */
@Controller
public class CartsController {
    // Atts
    private ICartsService cartsService;

    @Autowired
    public CartsController(ICartsService cartsService) {
        this.cartsService = cartsService;
    }

    @GetMapping({ "carts" })
    public String carts(Model model) {
        model.addAttribute("carts", cartsService.getCarts());
        return "carts";
    }

    @GetMapping({ "/carts/delete/all" })
    public String deletecarts() {
        cartsService.deleteCarts();
        return "redirect:/carts";
    }

    @GetMapping({ "/carts/populate" })
    public String populateCarts() {
        cartsService.populateCarts();
        return "redirect:/carts";
    }
}