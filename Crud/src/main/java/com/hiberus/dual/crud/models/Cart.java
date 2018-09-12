package com.hiberus.dual.crud.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * Cart
 */
@Entity
@Data
public class Cart {
    // Atts
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    /* @Getter(AccessLevel.NONE) */
    /* @Setter(AccessLevel.NONE) */
    private Cupon cupon;
    private Float discount = 0F;
    private Float totalPrice;

    // Relations
    @ManyToMany(mappedBy = "carts")
    private List<Product> products;

    // Ctor
    public Cart() {
    }

    public Cart(Long id, String name, ArrayList<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    // Methods
    private Float calculateDiscount(Float amaunt) {
        Float discountPrice = null; 

        if (cupon.equals(Cupon.PERCENTAGE)) {
            discountPrice = amaunt * this.discount;
        } else if (cupon.equals(Cupon.ABSOLUTE)) {
            discountPrice = this.discount;
        }
        return discountPrice;
    }

    public void setTotalPrice() {
        this.totalPrice = 0F;
        products.forEach(p -> this.totalPrice += p.getTotalPrice());
        this.totalPrice += calculateDiscount(this.totalPrice);
    }

    public String getTotalPriceEur() {
        return String.format("%1$.2f€", this.totalPrice);
    }

    public void setDiscount(Cupon cupon, Float discount) {
        this.cupon = cupon;
        this.discount = discount;
    }
}
