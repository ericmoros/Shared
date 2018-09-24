package com.hiberus.dual.hotel.repositorios;

import com.hiberus.dual.hotel.modelos.hotel.Reserva;

import org.springframework.data.repository.CrudRepository;

/**
 * ReservaRepositorio
 */
public interface ReservaRepositorio extends CrudRepository<Reserva, Long> {  
}
