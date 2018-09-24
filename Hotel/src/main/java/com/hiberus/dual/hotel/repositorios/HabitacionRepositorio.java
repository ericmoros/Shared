package com.hiberus.dual.hotel.repositorios;

import com.hiberus.dual.hotel.modelos.habitacion.Habitacion;

import org.springframework.data.repository.CrudRepository;

/**
 * HabitacionRepositorio
 */
public interface HabitacionRepositorio extends CrudRepository<Habitacion, Long> { 
}
