package com.hiberus.dual.hotel.repositorios;

import com.hiberus.dual.hotel.modelos.habitacion.HabitacionTipo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * HabitacionTipoRepositorio
 */
@Repository
public interface HabitacionTipoRepositorio extends CrudRepository<HabitacionTipo, Long> {
}