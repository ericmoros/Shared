package com.hiberus.dual.hotel.modelos.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.hiberus.dual.hotel.modelos.habitacion.Extra;
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
    @Column(name = "fecha_inicio")
    private LocalDate fechai;
    @Column(name = "fecha_final")
    private LocalDate fechaf;
    // @Column(name = "referencia")
    // private String referencia;
    // Relations
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<Habitacion> habitaciones;

    // Ctor
    public Reserva() {
    }

    public BigDecimal Precio(List<Habitacion> habitaciones) {
        BigDecimal sum = new BigDecimal("0").setScale(2, BigDecimal.ROUND_UP);
        for (Habitacion h : habitaciones) {
            sum = sum.add(h.getTipo().getPrecio());
            for (Extra e : h.getExtras()) {
                sum = sum.add(e.getPrecio());
            }
        }
        return sum;
    }

    // public String getReferencia() {
    //     String referencia = "";
    //     referencia = fechai + "" + fechaf + "" + usuario.getId();
    //     return referencia;
    // }
}
