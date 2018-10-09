package es.hiberus.hotel.domain;

import javax.persistence.Entity;

@Entity
public class Administrador extends Cliente {

	// Methods
	@Override
	public String toString() {
		return "Administrador [toString()=" + super.toString() + "]";
	}
	
	
}
