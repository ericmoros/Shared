package com.hiberus.dual.hotel.repositorios;

import com.hiberus.dual.hotel.modelos.hotel.Hotel;

import org.springframework.data.repository.CrudRepository;

/**
 * HotelRepositorio
 */
public interface HotelRepositorio extends CrudRepository<Hotel, Long> {  
}
