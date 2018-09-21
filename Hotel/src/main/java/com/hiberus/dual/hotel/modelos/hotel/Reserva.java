package com.hiberus.dual.hotel.modelos.hotel;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.hiberus.dual.hotel.modelos.usuario.Usuario;

import lombok.Data;

/**
 * reserva
 */
@Entity
@Data
public class Reserva {
    // Atts
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "fecha_i")
    private Date fechai;
    @Column(name = "fecha_f")
    private Date fechaf;
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuarios;

    //Ctor
    public Reserva() {
    }

}
