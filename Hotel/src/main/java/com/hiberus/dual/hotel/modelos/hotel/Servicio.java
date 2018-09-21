package com.hiberus.dual.hotel.modelos.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * servicio
 */
@Entity
@Data
public class Servicio {
    //Atts
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="extra")
    private AtributoEnum extra;
    @Column(name="referencia")
    private String referencia;
    
}
