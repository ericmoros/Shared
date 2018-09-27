package com.hiberus.dual.hotel.repositorios;


import com.hiberus.dual.hotel.modelos.habitacion.Atributo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * HabitacionRepositorio
 */
@Repository
public interface AtributoRepositorio extends CrudRepository<Atributo, Long> { 
}
