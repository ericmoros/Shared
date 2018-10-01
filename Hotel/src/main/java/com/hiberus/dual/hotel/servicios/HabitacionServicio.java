package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.habitacion.Habitacion;
import com.hiberus.dual.hotel.repositorios.HabitacionRepositorio;
import com.hiberus.dual.hotel.servicios.interfaces.IHabitacionServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HabitacionServicio
 */
@Service
public class HabitacionServicio implements IHabitacionServicio{

    private HabitacionRepositorio hR;

    @Autowired
    public HabitacionServicio(HabitacionRepositorio hR) {
        this.hR = hR;
    }

    @Override
    public ArrayList<Habitacion> getAll() {
        return new ArrayList<Habitacion>((Collection<? extends Habitacion>) hR.findAll());
    }

    @Override
    public Habitacion get(Long id) {
        Habitacion habitacion = null;
        Optional<Habitacion> oU = hR.findById(id);
        if (oU.isPresent()) habitacion = oU.get();
        return habitacion;
    }

    @Override
    public void add(Habitacion habitacion) {
        hR.save(habitacion);
    }

    @Override
    public void update(Habitacion habitacion) {
        add(habitacion);// Por si cambia el método.
    }
 
    @Override
    public void remove(Long id) {
        hR.deleteById(id);
    }

    
}
