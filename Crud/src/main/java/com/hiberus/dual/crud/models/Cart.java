package com.hiberus.dual.crud.models;

import java.util.List;

import javax.persistence.Embedded;
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
    private Float totalPrice = 0F;
    private Float price = 0F;
    // Relations
    @ManyToMany(mappedBy = "carts")
    private List<Product> products;
    @Embedded
    private CouponEmbebido coupon;

    // Ctor
    public Cart() {
    }

    public Cart(Long id, String name, CouponEmbebido coupon, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.coupon = coupon;
        setPrice();
        setTotalPrice();
    }

    // Methods
    private Float calculateDiscount(Float amaunt) {
        Float discountPrice = 0F;

        if (this.coupon != null) {
            if (CouponType.PERCENTAGE.equals(coupon.getCouponType())) {
                discountPrice = amaunt * this.coupon.getAmount();
            } else if (CouponType.ABSOLUTE.equals(coupon.getCouponType())) {
                discountPrice = this.coupon.getAmount();
            }
        }
        return discountPrice;
    }

    public void setPrice() {
        this.price = 0F;
        for (Product p : this.products) {
            Float pPrice = p.getTotalPrice();
            this.price += pPrice;
        }
    }

    public String getPriceEur() {
        return String.format("%1$.2f€", this.price);
    }

    public void setTotalPrice() {
        this.totalPrice = this.price - calculateDiscount(this.price);
        if (this.totalPrice < 0) this.totalPrice = 0F;
    }

    public String getTotalPriceEur() {
        return String.format("%1$.2f€", this.totalPrice);
    }
}
