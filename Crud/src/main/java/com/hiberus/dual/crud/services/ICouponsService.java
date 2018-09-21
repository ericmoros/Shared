package com.hiberus.dual.crud.services;

import java.util.ArrayList;
import java.util.Arrays;

import com.hiberus.dual.crud.models.Coupon;
import com.hiberus.dual.crud.models.CouponType;

/**
 * ICouponsService
 * @see CouponsService
 */
public interface ICouponsService {
    // Atts
    ArrayList<Coupon> COUPONS = new ArrayList<>(
        Arrays.asList(
            new Coupon[] {
                new Coupon(1L, "ABCDEFGHIJKLMNABS001", CouponType.ABSOLUTE, 6F),
                new Coupon(2L, "ABCDEFGHIJKLMNABS002", CouponType.ABSOLUTE, 2.2F),
                new Coupon(3L, "ABCDEFGHIJKLMNPER003", CouponType.PERCENTAGE, 50F),
                new Coupon(4L, "ABCDEFGHIJKLMNPER004", CouponType.PERCENTAGE, 20.3F)
            }
        )
    );
    
    // Methods
    ArrayList<Coupon> getCoupons();

    Coupon getCoupon(Long id);

    void deleteCoupon(Long id);

    void populateCoupons();

    void addCoupons(ArrayList<Coupon> coupons);

    void editCoupon(Coupon coupon);

    void deleteCoupons();

    void addCoupon(Coupon coupon);
}