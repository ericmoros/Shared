package com.hiberus.dual.hotel.modelos.usuario;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
import com.hiberus.dual.hotel.modelos.hotel.Hotel;

/**
 * gerente
 */
@Entity
public class Gerente extends Cliente {
    // Atts
    @ManyToOne
    private Hotel hotel;

    // Ctor
    public Gerente() {
        super();
    }
    
    public Gerente(Long id, EstadoEnum estado, String dni, String nombre) {
        super(id, estado, dni, nombre);
    }

    public Gerente(Gerente administrador) {
        super(administrador.getId(), administrador.getEstado(), administrador.getDni(), administrador.getNombre());
    }
}
