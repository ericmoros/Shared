package com.hiberus.dual.hotel.repositorios;

import com.hiberus.dual.hotel.modelos.habitacion.Habitacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * HabitacionRepositorio
 */
@Repository
public interface HabitacionRepositorio extends CrudRepository<Habitacion, Long> { 
}
