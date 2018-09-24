package com.hiberus.dual.hotel.modelos.usuario;

import java.util.ArrayList;

import javax.persistence.Entity;

import com.hiberus.dual.hotel.modelos.hotel.Reserva;

/**
 * cliente
 */
@Entity
public class Cliente extends Usuario{
    
    //Ctor
    public Cliente() {
        super();
    }
    public Cliente(String dni, String nombre, ArrayList<Reserva> reservas) {
        super();
    }
}
