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
public class Extra {
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
    public Extra() {
    }

    public Extra(Long id, EstadoEnum estado, String nombre, BigDecimal precio) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Extra(Extra extra) {
        this.id = extra.getId();
        this.estado = extra.getEstado();
        this.nombre = extra.getNombre();
        this.precio = extra.getPrecio();
    }

}