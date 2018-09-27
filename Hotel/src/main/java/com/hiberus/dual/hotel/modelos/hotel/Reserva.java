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
<<<<<<< HEAD
    @Column(name = "referencia")
    private String referencia;
=======
    // @Column(name = "referencia")
    // private String referencia;
>>>>>>> e828d25389837129d35a5491923ffa349efa5853
    // Relations
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<Habitacion> habitaciones;

    // Ctor
    public Reserva() {
        this.referencia = referencias();
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

<<<<<<< HEAD
    public String referencias() {
        String referencia;
        referencia = fechai + "" + fechaf + "" + usuario.getId();
        return referencia;
    }
=======
    // public String getReferencia() {
    //     String referencia = "";
    //     referencia = fechai + "" + fechaf + "" + usuario.getId();
    //     return referencia;
    // }
>>>>>>> e828d25389837129d35a5491923ffa349efa5853
}
