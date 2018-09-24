package com.hiberus.dual.hotel.modelos.usuario;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.hiberus.dual.hotel.modelos.hotel.Hotel;
import com.hiberus.dual.hotel.modelos.hotel.Reserva;

/**
 * gerente
 */
@Entity
public class Gerente extends Usuario {
    @ManyToOne
    private Hotel hotel;

    public Gerente(String dni, String nombre, ArrayList<Reserva> reservas) {
        super();
    }
}
