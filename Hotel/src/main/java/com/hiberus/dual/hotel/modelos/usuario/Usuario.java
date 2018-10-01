package com.hiberus.dual.hotel.modelos.usuario;

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
 * usuario
 */
@Entity
@Data
public abstract class Usuario {
    // Atts
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum estado;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nombre")
    private String nombre;

    // Ctor
    public Usuario() {
    }

    public Usuario(Long id, EstadoEnum estado, String dni, String nombre) {
        this.id = id;
        this.estado = estado;
        this.dni = dni;
        this.nombre = nombre;
    }

    public Usuario(Usuario usuario) {
        this.id = usuario.getId();
        this.estado = usuario.getEstado();
        this.dni = usuario.getDni();
        this.nombre = usuario.getNombre();
    }

    
}
