package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;

import com.hiberus.dual.hotel.modelos.hotel.Reserva;

/**
 * IReservaServicio
 */
public interface IReservaServicio {

    ArrayList<Reserva> getAll();

    Reserva get(Long id);

    void add(Reserva reserva);

    void update(Reserva reserva);

    void remove(Long id);
}