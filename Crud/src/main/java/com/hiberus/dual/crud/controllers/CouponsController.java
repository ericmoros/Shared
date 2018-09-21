package com.hiberus.dual.crud.controllers;

import com.hiberus.dual.crud.models.Coupon;
import com.hiberus.dual.crud.services.ICouponsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * CouponController
 */
@Controller
public class CouponsController {
    // Atts
    private ICouponsService couponsService;

    // Ctor
    public CouponsController(ICouponsService couponsService) {
        this.couponsService = couponsService;
    }

    // Methods
    @GetMapping({ "/coupons" })
    public String coupons(Model model) {
        model.addAttribute("coupons", couponsService.getCoupons());
        return "coupons";
    }
    
    @GetMapping({"/coupons/populate"})
    public String populateCoupons() {
        couponsService.populateCoupons();
        return "redirect:/coupons";
    }

    @GetMapping({"/coupons/delete/all"})
    public String deleteCoupons() {
        couponsService.deleteCoupons();
        return "redirect:/coupons";
    }

    @GetMapping({"/coupons/delete/{id}"})
    public String deleteCoupon(@PathVariable Long id) {
        couponsService.deleteCoupon(id);
        return "redirect:/coupons";
    }

    @PostMapping({"/coupons/add"})
    public String couponAdd(@ModelAttribute("Coupon") Coupon coupon) {
        couponsService.addCoupon(coupon);
        return "redirect:/coupons";
    }
}