package com.hiberus.dual.hotel.modelos.hotel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * hotel
 */
@Entity
@Data
public class Hotel {
    // Atts
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "cif")
    private String cif;

    @Column(name = "calle")
    private String calle;

    @Column(name = "nombre")
    private String nombre;

    // Relations
    @OneToMany
    private List<Servicio> servicios;

    // Ctor
    public Hotel() {
    }

    public Hotel(String cif, String calle, String nombre) {
        this.cif = validateCif(cif);
        this.calle = calle;
        this.nombre = nombre;
    }

    // Methods
    private String validateCif(String cif2) {
        Validador validador = new Validador();
		int e = validador.checkNif(input);
        return null;
    }

}
