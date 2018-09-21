package com.hiberus.dual.crud.services;

import com.hiberus.dual.crud.models.Cart;
import com.hiberus.dual.crud.models.CouponEmbebido;

/**
 * ICartService
 * @see CartService
 */
public interface ICartService {

    Cart getCart();

    CouponEmbebido getCoupon();

    void resetCart();

    void addProduct(Long id);
    
    void deleteProduct(Long id);
    
    void addCoupon(String coupon);
    
    void deleteCoupon();
}