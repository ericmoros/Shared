package com.hiberus.dual.hotel.repositorios;

import com.hiberus.dual.hotel.modelos.habitacion.Extra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * HabitacionRepositorio
 */
@Repository
public interface ExtraRepositorio extends CrudRepository<Extra, Long> { 
}
