package es.hiberus.hotel.service;

import org.springframework.stereotype.Service;

import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.Gerente;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Reserva;
import es.hiberus.hotel.domain.Servicio;

@Service
public interface GerenteService extends UsuarioService{
	
	Habitacion modificarEstado(Habitacion habitacion, EstadoHabitacion estado);
	
	Reserva modificarReserva(Gerente gerente, Reserva reservaAcutal, Reserva reservaNueva);
	
	Reserva anularReserva(Reserva reserva);
	
	Reserva confirmarReserva(Reserva reserva);
	
	Servicio crearServicio(Servicio servicio);
	
	Servicio eliminarServicio(Servicio servicio);
	
	Servicio modificarServicio(Servicio servicioActual, Servicio servicioNuevo);

}