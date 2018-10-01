package com.hiberus.dual.hotel.modelos.habitacion;

import java.math.BigDecimal;

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
 * Atributo
 */
@Entity
@Data
public class Atributo {
    // Atts
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum estado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    // Ctor
    public Atributo() {
    }

    public Atributo(Long id, EstadoEnum estado, String nombre, BigDecimal precio) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Atributo(Atributo atributo) {
        this.id = atributo.getId();
        this.estado = atributo.getEstado();
        this.nombre = atributo.getNombre();
        this.precio = atributo.getPrecio();
    }

    //Fluents
    public Atributo id(Long id) {
        this.id = id;
        return this;
    }

    public Atributo estado(EstadoEnum estado) {
        this.estado = estado;
        return this;
    }

    public Atributo nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Atributo precio(BigDecimal precio) {
        this.precio = precio;
        return this;
    }


}
