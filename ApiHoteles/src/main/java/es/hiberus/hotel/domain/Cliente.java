package es.hiberus.hotel.domain;

import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {
	// Methods
	@Override
	public String toString() {
		return "Cliente [toString()=" + super.toString() + "]";
	}
	
}
