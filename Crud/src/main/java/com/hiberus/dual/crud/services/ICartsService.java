package com.hiberus.dual.crud.services;

import java.util.ArrayList;
import java.util.Arrays;

import com.hiberus.dual.crud.models.Cart;
import com.hiberus.dual.crud.models.CouponEmbebido;
import com.hiberus.dual.crud.models.CouponType;
import com.hiberus.dual.crud.models.Product;

/**
 * ICarts
 * @see CartsService
 */
public interface ICartsService {
    // Atts
    ArrayList<Cart> CARTS = new ArrayList<Cart>(
        Arrays.asList(
            new Cart[] {
                new Cart(1L, "Eric's cart", new CouponEmbebido(1L, "ABCDEFGHIJKLMNABS001", CouponType.ABSOLUTE, 6F), new ArrayList<Product>(
                    Arrays.asList(
                        new Product[] {
                            new Product(1, "Leche", 2.87F, 1, "No description"),
                            new Product(2, "Arroz", 0.61F, 1, "No description"),
                            new Product(3, "Maizena", 1.27F, 7, "No description"),
                            new Product(4, "Café soluble", 2.00F, 200, "No description"),
                            new Product(5, "Frijol", 2.55F, 2, "No description"),
                            new Product(6, "Sopa", 0.15F, 7, "No description"),
                            new Product(7, "Huevos", 1.89F, 2, "No description"),
                            new Product(8, "Consomate", 0.45F, 8, "No description")
                        }
                    )
                )),
                new Cart(1L, "Susan's cart", new CouponEmbebido(4L, "ABCDEFGHIJKLMNPER004", CouponType.PERCENTAGE, 20.3F), new ArrayList<Product>(
                    Arrays.asList(
                        new Product[] {
                            new Product(1, "Leche", 2.87F, 1, "No description"),
                            new Product(2, "Arroz", 0.61F, 1, "No description"),
                            new Product(3, "Maizena", 1.27F, 7, "No description"),
                            new Product(4, "Café soluble", 2.00F, 200, "No description"),
                            new Product(5, "Frijol", 2.55F, 2, "No description"),
                            new Product(6, "Sopa", 0.15F, 7, "No description"),
                            new Product(7, "Huevos", 1.89F, 2, "No description"),
                            new Product(8, "Consomate", 0.45F, 8, "No description")
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