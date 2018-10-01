package com.hiberus.dual.hotel.servicios.interfaces;

import java.util.ArrayList;

import com.hiberus.dual.hotel.modelos.hotel.Servicio;

/**
 * IServicioServicio
 */
public interface IServicioServicio {

    ArrayList<Servicio> getAll();

    Servicio get(Long id);

    void add(Servicio servicio);

    void update(Servicio servicio);

    void remove(Long id);


}
