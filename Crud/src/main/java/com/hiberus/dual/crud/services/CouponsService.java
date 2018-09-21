package com.hiberus.dual.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hiberus.dual.crud.models.Coupon;
import com.hiberus.dual.crud.repositories.CouponsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CouponsService
 */
@Service
public class CouponsService implements ICouponsService {
    // Atts
    private CouponsRepository couponsRepository;

    // Ctor
    @Autowired
    public CouponsService(CouponsRepository couponsRepository) {
        this.couponsRepository = couponsRepository;
    }

    // Methods
    @Override
    public ArrayList<Coupon> getCoupons() {
        ArrayList<Coupon> coupons = new ArrayList<>();
        couponsRepository.findAll().forEach(coupons::add);
        return coupons;
    }

    @Override
    public Coupon getCoupon(Long id) {
        Coupon Coupon = null;
        Optional<Coupon> oCoupon;
        oCoupon = couponsRepository.findById(id);
        if (oCoupon.isPresent())
            Coupon = oCoupon.get();
        return Coupon;
    }

    @Override
    public void deleteCoupon(Long id) {
        couponsRepository.deleteById(id);
    }

    @Override
    public void deleteCoupons() {
        couponsRepository.deleteAll();
    }

    @Override
    public void populateCoupons() {
        couponsRepository.saveAll(COUPONS);
    }

    @Override
    public void addCoupons(ArrayList<Coupon> Coupons) {
        couponsRepository.saveAll(Coupons);
    }

    @Override
    public void editCoupon(Coupon Coupon) {
        couponsRepository.save(Coupon);
    }

    @Override
    public void addCoupon(Coupon coupon) {
        couponsRepository.save(coupon);
    }
}