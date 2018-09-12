package com.hiberus.dual.crud.repositories;

import com.hiberus.dual.crud.models.Cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CartsRepository
 */
@Repository
public interface CartsRepository extends CrudRepository<Cart, Long> {
}