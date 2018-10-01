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

    @Column(name = "referencia")
    private String referencia;

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

    public Reserva(Long id, String referencia, EstadoEnum estado, LocalDate fechai, LocalDate fechaf, Usuario usuario, List<Habitacion> habitaciones, BigDecimal precio) {
        this.id = id;
        this.referencia = referencia;
        this.estado = estado;
        this.fechai = fechai;
        this.fechaf = fechaf;
        this.usuario = usuario;
        this.habitaciones = habitaciones;
        this.precio = precio;
    }

    public Reserva(Reserva reserva) {
        this.id = reserva.getId();
        this.referencia = reserva.getReferencia();
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

    public String getReferencia() {
        String referencia = "";
        referencia = fechai + "" + usuario.getId();
        return referencia;
    }

    
}
