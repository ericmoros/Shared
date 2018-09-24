package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;

import com.hiberus.dual.hotel.modelos.hotel.Hotel;

/**
 * IHotelServicio
 */
public interface IHotelServicio {

    ArrayList<Hotel> getAll();

    Hotel get(Long id);

    void add(Hotel hotel);

    void update(Hotel hotel);

    void remove(Long id);
}