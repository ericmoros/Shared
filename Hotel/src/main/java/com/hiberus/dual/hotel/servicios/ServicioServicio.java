package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.hotel.Servicio;
import com.hiberus.dual.hotel.repositorios.ServicioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ServicioServicio
 */
public class ServicioServicio implements IServicioServicio {

    private ServicioRepositorio sR;

    @Autowired
    public ServicioServicio(ServicioRepositorio sR) {
        this.sR = sR;
    }

    @Override
    public ArrayList<Servicio> getAll() {
        return new ArrayList<Servicio>((Collection<? extends Servicio>) sR.findAll());
    }

    @Override
    public Servicio get(Long id) {
        Servicio servicio = null;
        Optional<Servicio> oU = sR.findById(id);
        if (oU.isPresent()) servicio = oU.get();
        return servicio;
    }

    @Override
    public void add(Servicio servicio) {
        sR.save(servicio);
    }

    @Override
    public void update(Servicio servicio) {
        add(servicio);// Por si cambia el método.
    }
 
    @Override
    public void remove(Long id) {
        sR.deleteById(id);
    }
}