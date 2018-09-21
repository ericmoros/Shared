package com.hiberus.dual.crud.repositories;

import com.hiberus.dual.crud.models.Coupon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CouponsService
 */
@Repository
public interface CouponsRepository extends CrudRepository<Coupon, Long> {
}