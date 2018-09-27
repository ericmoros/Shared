package com.hiberus.dual.hotel.servicios.interfaces;

import java.util.ArrayList;

import com.hiberus.dual.hotel.modelos.habitacion.Atributo;



/**
 * IExtraServicio
 * @see ExtraServicio
 */
public interface IAtributoServicio {
    ArrayList<Atributo> getAll();

    Atributo get(Long id);

    void add(Atributo atributo);

    void update(Atributo atributo);

    void remove(Long id);
}