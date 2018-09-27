package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.hotel.Reserva;
import com.hiberus.dual.hotel.repositorios.ReservaRepositorio;
import com.hiberus.dual.hotel.servicios.interfaces.IReservaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ReservaServicio
 */
@Service

public class ReservaServicio implements IReservaServicio {

    private ReservaRepositorio rR;

    @Autowired
    public ReservaServicio(ReservaRepositorio rR) {
        this.rR = rR;
    }

    @Override
    public ArrayList<Reserva> getAll() {
        return new ArrayList<Reserva>((Collection<? extends Reserva>) rR.findAll());
    }

    @Override
    public Reserva get(Long id) {
        Reserva reserva = null;
        Optional<Reserva> oU = rR.findById(id);
        if (oU.isPresent())
            reserva = oU.get();
        return reserva;
    }

    @Override
    public void add(Reserva reserva) {
        rR.save(reserva);
    }

    @Override
    public void update(Reserva reserva) {
        add(reserva);// Por si cambia el método.
    }

    @Override
    public void remove(Long id) {
        rR.deleteById(id);
    }
}