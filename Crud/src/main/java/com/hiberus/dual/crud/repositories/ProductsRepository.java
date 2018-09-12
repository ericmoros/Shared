package com.hiberus.dual.crud.repositories;

import com.hiberus.dual.crud.models.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductsRepository
 */
@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {
}