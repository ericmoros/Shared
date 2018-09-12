package com.hiberus.dual.crud.services;

import java.util.ArrayList;
import java.util.Arrays;

import com.hiberus.dual.crud.models.Cart;
import com.hiberus.dual.crud.models.Product;

/**
 * ICarts
 */
public interface ICartsService {
    // Atts
    ArrayList<Cart> CARTS = new ArrayList<>(
        Arrays.asList(
            new Cart[]{
                new Cart(1L, "Eric's cart", new ArrayList<Product>(
                    Arrays.asList(
                        new Product[]{
                            IProductsService.PRODUCTS.get(0),
                            IProductsService.PRODUCTS.get(1),
                            IProductsService.PRODUCTS.get(2),
                            IProductsService.PRODUCTS.get(3),
                            IProductsService.PRODUCTS.get(4),
                            IProductsService.PRODUCTS.get(5),
                            IProductsService.PRODUCTS.get(6)
                        }
                    )
                )),
                new Cart(2L, "Susan's cart", new ArrayList<Product>(
                    Arrays.asList(
                        new Product[]{
                            IProductsService.PRODUCTS.get(1),
                            IProductsService.PRODUCTS.get(4),
                            IProductsService.PRODUCTS.get(5),
                            IProductsService.PRODUCTS.get(6)
                        }
                    )
                ))
            }
        )
    );

    // Methods
    ArrayList<Cart> getCarts();

    Cart getCart(Long id);

    void deleteCarts();

    void populateCarts();

    void addCart(Cart cart);
}