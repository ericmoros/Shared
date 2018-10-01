package com.hiberus.dual.hotel.modelos.usuario;

import javax.persistence.Entity;

import com.hiberus.dual.hotel.modelos.EstadoEnum;

/**
 * administrador
 */
@Entity
public class Administrador extends Cliente {

    //Ctor
    public Administrador() {
        super();
    }
    
    public Administrador(Long id, EstadoEnum estado, String dni, String nombre) {
        super(id, estado, dni, nombre);
    }

    public Administrador(Administrador administrador) {
        super(administrador.getId(), administrador.getEstado(), administrador.getDni(), administrador.getNombre());
    }

    
}
