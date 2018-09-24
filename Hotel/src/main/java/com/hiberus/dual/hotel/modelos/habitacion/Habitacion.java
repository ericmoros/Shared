package com.hiberus.dual.hotel.modelos.habitacion;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    
    @Column(name = "numero")
    private String numero;
    
    @Column(name = "precio")
    private BigDecimal precio;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private HabitacionTipoEnum tipo;
    
    @Column(name = "extras")
    private AtributoEnum extra;

    @OneToOne
    private Hotel hotel;

    // @Column(name = "id_reserva")
    // @OneToOne
    // private Reserva idReserva;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum es;

    //Ctor
    public Habitacion() {
        super();
    }

    public Habitacion(Hotel hotel, String numero, HabitacionTipoEnum tipo, AtributoEnum extra, Reserva res,
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
        Float ex = new Float(1);
        if (HabitacionTipoEnum.INDIVIDUAL.equals(tipo)) {
            sum = ex * 10.7F;
        } else if (HabitacionTipoEnum.DOBLE.equals(tipo)) {
            sum = ex * 21.4F;
        }
        return sum;
    }
}