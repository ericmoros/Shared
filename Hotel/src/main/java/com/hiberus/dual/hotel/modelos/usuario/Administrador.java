package com.hiberus.dual.hotel.modelos.usuario;

import java.util.ArrayList;

import javax.persistence.Entity;

import com.hiberus.dual.hotel.modelos.hotel.Reserva;

/**
 * administrador
 */
@Entity
public class Administrador extends Usuario{

    public Administrador(String dni, String nombre, ArrayList<Reserva> reservas) {
        super();
    }

}
