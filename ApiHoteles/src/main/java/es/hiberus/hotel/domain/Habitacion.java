package es.hiberus.hotel.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Habitacion {
	// Atts
	@Id
	@GeneratedValue
	private Long id;
	
	private Boolean borrado = false;
	
	private int metros;
	
	// Relations
	@ManyToMany
	private List<Atributo> atributos = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private TipoHabitacion tipo;
	
	@Enumerated(EnumType.STRING)
	private EstadoHabitacion estado;
	
	@ManyToOne
	private Hotel hotel;

	
	// Getters&Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getBorrado() {
		return borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
	}

	public int getMetros() {
		return metros;
	}
	
	public void setMetros(int metros) {
		this.metros = metros;
	}
	
	public List<Atributo> getAtributos() {
		return atributos;
	}
	
	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
	
	public TipoHabitacion getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}
	
	public EstadoHabitacion getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoHabitacion estado) {
		this.estado = estado;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", metros=" + metros + ", atributos=" + atributos + ", tipo=" + tipo
				+ ", estado=" + estado + ", hotel=" + hotel + ", borrado=" + borrado + "]";
	}
	
	
}
