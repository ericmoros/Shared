package es.hiberus.hotel.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Gerente extends Cliente {
	
	@ManyToOne
	private Hotel hotel;
	
	// Methods
	@Override
	public String toString() {
		return "Gerente [toString()=" + super.toString() + "]";
	}

	//gtrs and strs
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}	
	
}
