package com.hiberus.dual.hotel.modelos.usuario;

import javax.persistence.Entity;

import com.hiberus.dual.hotel.modelos.EstadoEnum;

/**
 * cliente
 */
@Entity
public class Cliente extends Usuario {

    // Ctor
    public Cliente() {
        super();
    }

    public Cliente(Long id, EstadoEnum estado, String dni, String nombre) {
        super(id, estado, dni, nombre);
    }

    public Cliente(Cliente cliente) {
        super(cliente.getId(), cliente.getEstado(), cliente.getDni(), cliente.getNombre());
    }
}
