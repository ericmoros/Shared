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
import javax.persistence.OneToOne;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "hab_estado")
    private HabitacionEstadoEnum habEstado;

    @Column(name = "numero")
    private String numero;

    // Relations
    @OneToOne
    private HabitacionTipo tipo;

    @ManyToMany
    private List<Atributo> atributo;

    @OneToOne
    private Hotel hotel;

    
    // Ctor
    public Habitacion() {
    }
    
    public Habitacion(Long id, EstadoEnum estado, HabitacionEstadoEnum habEstado, String numero, HabitacionTipo tipo, List<Atributo> atributo, Hotel hotel) {
        this.id = id;
        this.estado = estado;
        this.habEstado = habEstado;
        this.numero = numero;
        this.tipo = tipo;
        this.atributo = atributo;
        this.hotel = hotel;
    }

    public Habitacion(Habitacion habitacion) {
        this.id = habitacion.getId();
        this.estado = habitacion.getEstado();
        this.habEstado = habitacion.getHabEstado();
        this.numero = habitacion.getNumero();
        this.tipo = habitacion.getTipo();
        this.atributo = habitacion.getAtributo();
        this.hotel = habitacion.getHotel();
    }


    // public Habitacion(Hotel hotel, String numero, HabitacionTipo tipo,
    // List<Extra> extras, Reserva res,
    // EstadoEnum es) {
    // // this.hotel = hotel;
    // this.numero = numero;
    // this.tipo = tipo;
    // this.extras = extras;
    // // this.res = res;
    // this.es = es;
    // // Coste();
    // }

    // Methods
    // public Float Coste() {
    // HabitacionTipoEnum tipo = null;
    // Float sum = null;
    // Float ex = new Float(extras.size());
    // if (HabitacionTipoEnum.INDIVIDUAL.equals(tipo)) {
    // sum = ex * 10.7F;
    // } else if (HabitacionTipoEnum.DOBLE.equals(tipo)) {
    // sum = ex * 21.4F;
    // }
    // return sum;
    // }
}
