package com.hiberus.dual.hotel.modelos.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hiberus.dual.hotel.modelos.EstadoEnum;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum estado;

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

    //Fluents
    public Servicio id(Long id) {
        this.id = id;
        return this;
    }

    public Servicio estado(EstadoEnum estado) {
        this.estado = estado;
        return this;
    }

    public Servicio nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    
}
