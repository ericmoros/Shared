package es.hiberus.hotel.service;

import java.util.List;

import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;

public interface BaseService {
	List<Hotel> listAllHoteles();

	List<Habitacion> listAllHabitaciones();

	List<Habitacion> findHabitacionByEstado(EstadoHabitacion estadoHabitacion);
}
