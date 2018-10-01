package com.hiberus.dual.hotel.modelos.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
import com.hiberus.dual.hotel.modelos.habitacion.Atributo;
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

    // @Column(name = "referencia")
    // private String referencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum estado;

    @Column(name = "fecha_inicio")
    private LocalDate fechai;

    @Column(name = "fecha_final")
    private LocalDate fechaf;

    @Column(name = "precio")
    private BigDecimal precio;

    // Relations
    @OneToOne
    private Usuario usuario;

    @OneToMany
    private List<Habitacion> habitaciones;

    public Reserva(Long id, EstadoEnum estado, LocalDate fechai, LocalDate fechaf, Usuario usuario, List<Habitacion> habitaciones, BigDecimal precio) { // TODO: String referencia
        this.id = id;
        this.estado = estado;
        this.fechai = fechai;
        this.fechaf = fechaf;
        this.usuario = usuario;
        this.habitaciones = habitaciones;
        this.precio = precio;
    }

    public Reserva(Reserva reserva) {
        this.id = reserva.getId();
        // this.referencia = reserva.getReferencia();
        this.estado = reserva.getEstado();
        this.fechai = reserva.getFechai();
        this.fechaf = reserva.getFechaf();
        this.usuario = reserva.getUsuario();
        this.habitaciones = reserva.getHabitaciones();
        this.precio = getPrecio();
    }

    // Ctor
    public Reserva() {
    }

    //Fluents
    public Reserva id(Long id) {
        this.id = id;
        return this;
    }

    public Reserva estado(EstadoEnum estado) {
        this.estado = estado;
        return this;
    }

    public Reserva fechai(LocalDate fechai) {
        this.fechai = fechai;
        return this;
    }

    public Reserva fechaf(LocalDate fechaf) {
        this.fechaf = fechaf;
        return this;
    }

    public Reserva precio(BigDecimal precio) {
        this.precio = precio;
        return this;
    }

    public Reserva usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Reserva habitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
        return this;
    }

    // Methods
    public BigDecimal getPrecio(List<Habitacion> habitaciones) {
        BigDecimal sum = new BigDecimal("0").setScale(2, BigDecimal.ROUND_UP);
        for (Habitacion h : habitaciones) {
            sum = sum.add(h.getTipo().getPrecio());
            for (Atributo e : h.getAtributo()) {
                sum = sum.add(e.getPrecio());
            }
        }
        return sum;
    }

    // public String getReferencia() {
    //     String referencia = "";
    //     referencia = fechai.toString() + "" + usuario.getId();
    //     return referencia;
    // }

    
}
