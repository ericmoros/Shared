package es.hiberus.hotel.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Hotel {
	// Atts
	@Id
	@GeneratedValue
	private Long id;
	
	private Boolean borrado = false;
	
	private String cif;
	
	private String nombre;
	
	private String calle;
	
	private int valoracion;
	
	// Relations
	@ManyToMany
	private List<Servicio> servicios = new ArrayList<>();
	
//	@OneToMany
//	private List<Habitacion> habitaciones = new ArrayList<>();

	
	//Getters&Setters
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
	
	public String getCif() {
		return cif;
	}
	
	public void setCif(String cif) {
		this.cif = cif;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public int getValoracion() {
		return valoracion;
	}
	
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	public List<Servicio> getServicios() {
		return servicios;
	}
	
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
//	public List<Habitacion> getHabitaciones() {
//		return habitaciones;
//	}
//	
//	public void setHabitaciones(List<Habitacion> habitaciones) {
//		this.habitaciones = habitaciones;
//	}

	// Methods
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
		Hotel other = (Hotel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", cif=" + cif + ", nombre=" + nombre + ", calle=" + calle + ", valoracion="
				+ valoracion + ", servicios=" + servicios + ", borrado=" + borrado + "]";
	}
	
	
}
