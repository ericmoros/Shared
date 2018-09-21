package com.hiberus.dual.crud.models;

import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

/**
 * Coupon
 */
// @Embeddable Por ahora lo quito porque no se si funciona
@Data
@Entity
public class Coupon {
    // Atts
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
    @Enumerated(EnumType.STRING)
    private CouponType couponType;
    private Float amount = 0F;

    // Ctor
    public Coupon() {
    }

    public Coupon(Long id, String code, CouponType cuponType, Float amount) {
        this.id = id;
        this.code = code;
        this.couponType = cuponType;
        this.amount = amount;
    }

    public Coupon(String code, Float amount) {
        this.code = code;
        this.amount = amount;
    }
    //Methods
    public String getAmountEur() {
        String amountEur = null;
        if (couponType.equals(CouponType.ABSOLUTE)) {
            amountEur = String.format("%1$.2f€", this.amount);
        } else if (couponType.equals(CouponType.PERCENTAGE)) {
            DecimalFormat df = new DecimalFormat("#.##%");
            amountEur = df.format(this.amount / 100F);
        }
        return amountEur;
    }
}