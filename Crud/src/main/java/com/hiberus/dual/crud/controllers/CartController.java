package com.hiberus.dual.crud.controllers;

import com.hiberus.dual.crud.services.ICartService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * CartController
 */
@Controller
public class CartController {
    private ICartService cartService;

    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping({ "cart" })
    public String cart(Model model) {
        model.addAttribute("products", cartService.getCart().getProducts());
        model.addAttribute("coupon", cartService.getCart().getCoupon());
        model.addAttribute("cart", cartService.getCart());
        return "cart";
    }

    @PostMapping({ "cart/confirm" })
    public String cartConfirmm(Model model) {

        return "carts";
    }

    @GetMapping({ "/cart/add/coupon/{code}" })
    public String addCoupon(@PathVariable String code) {
        cartService.addCoupon(code);
        return "redirect:/cart";
    }

    @PostMapping({ "/cart/add/coupon" })
    public String addCouponPost(String code) {
        cartService.addCoupon(code);
        return "redirect:/cart";
    }

    @GetMapping({ "/cart/add/product/{id}" })
    public String addProduct(@PathVariable Long id) {
        cartService.addProduct(id);
        return "redirect:/products";
    }

    @PostMapping({ "/cart/add/product" })
    public String addProductPost(Long id) {
        cartService.addProduct(id);
        return "redirect:/products";
    }

    @GetMapping({"/cart/delete/product/{id}"})
    public String deleteProduct(@PathVariable Long id) {
        cartService.deleteProduct(id);
        return "redirect:/cart";
    }

    @GetMapping({"/cart/delete/coupon"})
    public String deleteCoupon() {
        cartService.deleteCoupon();
        return "redirect:/cart";
    }
}