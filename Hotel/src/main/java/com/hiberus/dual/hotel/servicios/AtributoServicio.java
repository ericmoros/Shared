package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.habitacion.Atributo;
import com.hiberus.dual.hotel.repositorios.AtributoRepositorio;
import com.hiberus.dual.hotel.servicios.interfaces.IAtributoServicio;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ExtraServicio
 * @see IExtraServicio
 */
public class AtributoServicio implements IAtributoServicio {

    private AtributoRepositorio aR;

    @Autowired
    public AtributoServicio(AtributoRepositorio aR) {
        this.aR = aR;
    }

    @Override
    public ArrayList<Atributo> getAll() {
        return new ArrayList<Atributo>((Collection<? extends Atributo>) aR.findAll());
    }

    @Override
    public Atributo get(Long id) {
        Atributo atributo = null;
        Optional<Atributo> oU = aR.findById(id);
        if (oU.isPresent())
            atributo = oU.get();
        return atributo;
    }

    @Override
    public void add(Atributo atributo) {
        aR.save(atributo);
    }

    @Override
    public void update(Atributo atributo) {
        add(atributo);// Por si cambia el método.
    }

    @Override
    public void remove(Long id) {
        aR.deleteById(id);
    }

    
}
