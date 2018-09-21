package com.hiberus.dual.crud.models;

import java.text.DecimalFormat;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CouponEmbebido {
    // Atts
    private Long idCoupon;
    private String code;
    private CouponType couponType;
    private Float amount = 0F;

    public CouponEmbebido() {
    }

    //Ctor
    public CouponEmbebido(Long idCoupon, String code, CouponType couponType, Float amount) {
        this.idCoupon = idCoupon;
        this.code = code;
        this.couponType = couponType;
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