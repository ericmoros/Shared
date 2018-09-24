package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.hotel.Hotel;
import com.hiberus.dual.hotel.repositorios.HotelRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HotelServicio
 */
@Service
public class HotelServicio implements IHotelServicio {

    private HotelRepositorio hR;

    @Autowired
    public HotelServicio(HotelRepositorio hR) {
        this.hR = hR;
    }

    @Override
    public ArrayList<Hotel> getAll() {
        return new ArrayList<Hotel>((Collection<? extends Hotel>) hR.findAll());
    }

    @Override
    public Hotel get(Long id) {
        Hotel hotel = null;
        Optional<Hotel> oU = hR.findById(id);
        if (oU.isPresent()) hotel = oU.get();
        return hotel;
    }

    @Override
    public void add(Hotel hotel) {
        hR.save(hotel);
    }

    @Override
    public void update(Hotel hotel) {
        add(hotel);// Por si cambia el método.
    }
 
    @Override
    public void remove(Long id) {
        hR.deleteById(id);
    }
}