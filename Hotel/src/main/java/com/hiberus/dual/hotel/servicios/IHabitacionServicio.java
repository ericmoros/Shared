package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;

import com.hiberus.dual.hotel.modelos.habitacion.Habitacion;

/**
 * IHabitacionServicio
 */
public interface IHabitacionServicio {

    ArrayList<Habitacion> getAll();

    Habitacion get(Long id);

    void add(Habitacion habitacion);

    void update(Habitacion habitacion);

    void remove(Long id);

}
