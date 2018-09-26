package com.hiberus.dual.hotel.modelos.habitacion;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.hiberus.dual.hotel.modelos.hotel.Hotel;

import lombok.Data;

/**
 * habitacion
 */
@Entity
@Data
public class Habitacion {
    // Atts
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum es;
    
    // Relations
    @OneToOne
    private HabitacionTipo tipo;

    @ManyToMany
    private List<Extra> extras;

    @OneToOne
    private Hotel hotel;

    // Ctor
    public Habitacion() {
    }

    // public Habitacion(Hotel hotel, String numero, HabitacionTipo tipo, List<Extra> extras, Reserva res,
    //         EstadoEnum es) {
    //     // this.hotel = hotel;
    //     this.numero = numero;
    //     this.tipo = tipo;
    //     this.extras = extras;
    //     // this.res = res;
    //     this.es = es;
    //     // Coste();
    // }

    // Methods
    // public Float Coste() {
    //     HabitacionTipoEnum tipo = null;
    //     Float sum = null;
    //     Float ex = new Float(extras.size());
    //     if (HabitacionTipoEnum.INDIVIDUAL.equals(tipo)) {
    //         sum = ex * 10.7F;
    //     } else if (HabitacionTipoEnum.DOBLE.equals(tipo)) {
    //         sum = ex * 21.4F;
    //     }
    //     return sum;
    // }
}
