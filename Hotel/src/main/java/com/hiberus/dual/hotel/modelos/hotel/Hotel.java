package com.hiberus.dual.hotel.modelos.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * hotel
 */
@Entity
@Data
public class Hotel {
    //Atts
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="cif")
    private String cif;
    @Column(name="calle")
    private String calle;
    @Column(name="nombre")
    private String nombre;
    // TODO: Cambiar a OneToMany.
    @OneToOne
    private Servicio servicio;

    //Ctor
    public Hotel() {
    }
    public Hotel(String cif, String calle, String nombre) {
        this.cif = cif;
        this.calle = calle;
        this.nombre = nombre;
    }

}
