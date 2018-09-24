package com.hiberus.dual.hotel.modelos.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * usuario
 */
@Entity
@Data
public abstract class Usuario {
    // Atts
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="dni")
    private String dni;
    @Column(name="nombre")
    private String nombre;

    //Ctor
    public Usuario() {
    }
}
