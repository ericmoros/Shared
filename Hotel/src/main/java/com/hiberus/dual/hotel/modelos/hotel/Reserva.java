package com.hiberus.dual.hotel.modelos.hotel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.hiberus.dual.hotel.modelos.habitacion.Habitacion;
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
    @Column(name = "fecha_inicio")
    private Date fechai;
    @Column(name = "fecha_final")
    private Date fechaf;
    @OneToOne
    private Usuario usuario;
    // TODO: Cambiar a OneToMany
    @OneToOne
    private Habitacion habitacion;

    //Ctor
    public Reserva() {
    }

}
