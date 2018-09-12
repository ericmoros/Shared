package com.hiberus.dual.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hiberus.dual.crud.models.Cart;
import com.hiberus.dual.crud.repositories.CartsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CartsService
 */
@Service
public class CartsService implements ICartsService {
    // Atts
    private CartsRepository cartsRepository;

    // Ctor
    @Autowired
    public CartsService(CartsRepository cartsRepository) {
        this.cartsRepository = cartsRepository;
    }

    // Methods
    @Override
    public ArrayList<Cart> getCarts() {
        ArrayList<Cart> carts = new ArrayList<>();
        cartsRepository.findAll().forEach(carts::add);
        return carts;
    }

    @Override
    public Cart getCart(Long id) {
        Cart cart = null;
        Optional<Cart> ocart;
        ocart = cartsRepository.findById(id);
        if (ocart.isPresent())
            cart = ocart.get();
        return cart;
    }

    @Override
    public void deleteCarts() {
        cartsRepository.deleteAll();
    }

    @Override
    public void populateCarts() {
        cartsRepository.saveAll(CARTS);
    }

    @Override
    public void addCart(Cart cart) {
        cartsRepository.save(cart);
    }

}