package com.hiberus.dual.hotel.modelos.habitacion;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hiberus.dual.hotel.modelos.hotel.Hotel;
import com.hiberus.dual.hotel.modelos.hotel.Reserva;

import lombok.Data;

/**
 * habitacion
 */
@Entity
@Data
public class Habitacion {
    // Atts
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    // @Column(name = "hotel")
    // private Hotel hotel;
    @Column(name = "numero")
    private String numero;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private HabitacionTipoEnum tipo;
    @Column(name = "extra")
    private ArrayList<AtributoEnum> extra;
    // @Column(name = "res")
    // private Reserva res;
    @Enumerated(EnumType.STRING)
    @Column(name = "es")
    private EstadoEnum es;

    //Ctor
    public Habitacion() {
        super();
    }

    public Habitacion(Hotel hotel, String numero, HabitacionTipoEnum tipo, ArrayList<AtributoEnum> extra, Reserva res,
            EstadoEnum es) {
        // this.hotel = hotel;
        this.numero = numero;
        this.tipo = tipo;
        this.extra = extra;
        // this.res = res;
        this.es = es;
        Coste(tipo);
    }

    // Methods
    public Float Coste(HabitacionTipoEnum tipo) {
        Float sum = null;
        Float ex = new Float(extra.size());
        if (HabitacionTipoEnum.INDIVIDUAL.equals(tipo)) {
            sum = ex * 10.7F;
        } else if (HabitacionTipoEnum.DOBLE.equals(tipo)) {
            sum = ex * 21.4F;
        }
        return sum;
    }
}
