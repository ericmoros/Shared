package com.hiberus.dual.hotel.modelos.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * servicio
 */
@Entity
@Data
public class Servicio {
    // Atts
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "extra")
    private String nombre;

    // Ctor
    public Servicio() {
    }

    public Servicio(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Servicio(Servicio servicio) {
        this.id = servicio.getId();
        this.nombre = servicio.getNombre();
    }
}
