package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.habitacion.Extra;
import com.hiberus.dual.hotel.repositorios.ExtraRepositorio;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ExtraServicio
 * @see IExtraServicio
 */
public class ExtraServicio implements IExtraServicio {

    private ExtraRepositorio eR;

    @Autowired
    public ExtraServicio(ExtraRepositorio eR) {
        this.eR = eR;
    }

    @Override
    public ArrayList<Extra> getAll() {
        return new ArrayList<Extra>((Collection<? extends Extra>) eR.findAll());
    }

    @Override
    public Extra get(Long id) {
        Extra extra = null;
        Optional<Extra> oU = eR.findById(id);
        if (oU.isPresent())
            extra = oU.get();
        return extra;
    }

    @Override
    public void add(Extra extra) {
        eR.save(extra);
    }

    @Override
    public void update(Extra extra) {
        add(extra);// Por si cambia el método.
    }

    @Override
    public void remove(Long id) {
        eR.deleteById(id);
    }

}