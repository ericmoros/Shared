package com.hiberus.dual.hotel.servicios.interfaces;

import java.util.ArrayList;

import com.hiberus.dual.hotel.modelos.habitacion.Extra;

/**
 * IExtraServicio
 * @see ExtraServicio
 */
public interface IExtraServicio {
    ArrayList<Extra> getAll();

    Extra get(Long id);

    void add(Extra extra);

    void update(Extra extra);

    void remove(Long id);
}