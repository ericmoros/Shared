package com.hiberus.dual.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hiberus.dual.crud.models.Cart;
import com.hiberus.dual.crud.models.Coupon;
import com.hiberus.dual.crud.models.CouponEmbebido;
import com.hiberus.dual.crud.models.Product;

import org.springframework.stereotype.Service;

/**
 * CartService
 * @see ICartService
 */
@Service
public class CartService implements ICartService {
    // Atts
    private IProductsService productsService;
    private ICouponsService couponsService;
    private Cart cart;

    // Ctor
    public CartService(IProductsService productsService, ICouponsService couponsService) {
        this.productsService = productsService;
        this.couponsService = couponsService;
        this.cart = new Cart(0L, "Session cart", null, new ArrayList<Product>());
    }

    // Methods
    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void resetCart() {
        cart = new Cart(0L, "Session cart", null, new ArrayList<Product>());
    }

    @Override
    public void addProduct(Long id) {
        Product product = null;
        ArrayList<Product> products = productsService.getProducts();
        Optional<Product> oProduct = products.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (oProduct.isPresent()) {
            ArrayList<Product> cartProducts = new ArrayList<Product>(cart.getProducts());
            Optional<Product> oCartProduct = cartProducts.stream().filter(p -> p.getId().equals(id)).findFirst();
            
            if (oCartProduct.isPresent()) {
                product = oCartProduct.get();
                product.upStock();
            } else {
                product = new Product(oProduct.get());
                product.setStock(1);
                cart.getProducts().add(product);
            }
        }
    }

    @Override
    public void addCoupon(String code) {
        ArrayList<Coupon> coupons = couponsService.getCoupons();
        Optional<Coupon> oCoupon = coupons.stream().filter(p -> p.getCode().equals(code)).findFirst();
        if (oCoupon.isPresent()) {
            Coupon coupon = oCoupon.get();
            cart.setCoupon(new CouponEmbebido(coupon.getId(), coupon.getCode(), coupon.getCouponType(), coupon.getAmount()));
        }
    }

    @Override
    public CouponEmbebido getCoupon() {
        if (cart.getCoupon() != null) {
            return cart.getCoupon();
        } else {
            return null;
        }
    }

    @Override
    public void deleteProduct(Long id) {
        ArrayList<Product> cartProducts = new ArrayList<Product>(cart.getProducts());
        Optional<Product> oCartProduct = cartProducts.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (oCartProduct.isPresent()) {
            Product product = oCartProduct.get();
            cart.getProducts().remove(product);
        }
    }

    @Override
    public void deleteCoupon() {
        this.cart.setCoupon(null);
    }

}
