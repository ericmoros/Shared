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
 * HabitacionTipo
 */
@Entity
@Data
public class HabitacionTipo {
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
    public HabitacionTipo() {
    }

    public HabitacionTipo(Long id, EstadoEnum estado, String nombre, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }

    public HabitacionTipo(HabitacionTipo habitacionTipo) {
        this.id = habitacionTipo.getId();
        this.nombre = habitacionTipo.getNombre();
        this.precio = habitacionTipo.getPrecio();
        this.estado = habitacionTipo.getEstado();
    }

    //Fluents
    public HabitacionTipo id(Long id) {
        this.id = id;
        return this;
    }

    public HabitacionTipo estado(EstadoEnum estado) {
        this.estado = estado;
        return this;
    }

    public HabitacionTipo nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public HabitacionTipo precio(BigDecimal precio) {
        this.precio = precio;
        return this;
    }


}
