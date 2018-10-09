package es.hiberus.hotel.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "cliente_id", "fechaInicio" }) })
public class Reserva {
	// Atts
	@Id
	@GeneratedValue
	private Long id;
	
	private Boolean borrado = false;

	@Enumerated(EnumType.STRING)
	private EstadoReserva estado;

	private Date fechaInicio;

	private Date fechaFin;

	// Relations
	@ManyToMany
	private List<Habitacion> habitaciones = new ArrayList<>();
	
	@ManyToOne
	private Cliente cliente;


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
	
	public EstadoReserva getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

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
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado
				+ ", habitaciones=" + habitaciones + ", borrado=" + borrado + "]";
	}

}
