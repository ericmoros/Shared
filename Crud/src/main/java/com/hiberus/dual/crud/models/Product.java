package com.hiberus.dual.crud.models;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * Product
 */
@Data
@Entity
public class Product {
    // Atts
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Float price;
    private Float totalPrice;
    private Integer stock = 0;
    private String description;

    //Relations
    @ManyToMany
    private List<Cart> carts = new ArrayList<>();

    // Ctor
    public Product() {
    }

    public Product(long id, String name, float price, int stock, String description) {
        this.id = id;
        this.name = name;
        setPrice(price);
        this.stock = stock;
        this.description = description;
    }

    // Methods
    public void setPrice(Float price) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.HALF_UP); 
        this.price = new Float(formatter.format(price));
    }

    public void setTotalPrice() {
        this.totalPrice = this.price * this.stock;
    }

    public String getPriceEur() {
        return String.format("%1$.2f€", this.price);
    }
}