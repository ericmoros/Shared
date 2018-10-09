package es.hiberus.hotel.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.EstadoReserva;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Reserva;


public abstract class ReservaUtil {
	public static Reserva crear(List<Habitacion> habitaciones, Cliente cliente) {
		Reserva reserva = new Reserva();
		reserva.setBorrado(false);
		reserva.setEstado(EstadoReserva.ANULADA);
		reserva.setFechaInicio(new Date(999999));
		reserva.setFechaFin(new Date(999999));
		reserva.setCliente(cliente);
		reserva.setHabitaciones(habitaciones);
		return reserva;
	}
	
	private static List<Reserva> crearLista(List<Habitacion> habitaciones, Cliente cliente, Integer size) {
		List<Reserva> reservaes = new ArrayList<Reserva>();
		Reserva reserva = null;
		for (int i = 0; i < size; i++) {
			reserva = crear(habitaciones, cliente);
			reservaes.add(reserva);
		}
		return reservaes;
	}
	
	public static List<Reserva> crearLista(List<Habitacion> habitaciones, Cliente cliente) {
		return crearLista(habitaciones, cliente, 4);
	}

	public static Reserva clonar(Reserva reserva) {
		Reserva reservaClonado = new Reserva();
		reservaClonado.setId(reserva.getId());
		reservaClonado.setBorrado(reserva.getBorrado());
		reservaClonado.setEstado(reserva.getEstado());
		reservaClonado.setFechaInicio(reserva.getFechaInicio());
		reservaClonado.setFechaFin(reserva.getFechaFin());
		reservaClonado.setCliente(reserva.getCliente());
		reservaClonado.setHabitaciones(reserva.getHabitaciones());
		return reservaClonado;
	}
	
	public static void copiar(Reserva reservaActual, Reserva reservaNueva) {
		reservaActual.setId(reservaNueva.getId());
		reservaActual.setBorrado(reservaNueva.getBorrado());
		reservaActual.setEstado(reservaNueva.getEstado());
		reservaActual.setFechaInicio(reservaNueva.getFechaInicio());
		reservaActual.setFechaFin(reservaNueva.getFechaFin());
		reservaActual.setCliente(reservaNueva.getCliente());
		reservaActual.setHabitaciones(reservaNueva.getHabitaciones());
	}
	
	public static List<Reserva> clonarReservas(List<Reserva> reservaes) {
		List<Reserva> reservaesClonados = new ArrayList<Reserva>(); 
		Reserva reservaClonado = null;
		for (Reserva reserva : reservaes) {
			reservaClonado = clonar(reserva);
			reservaesClonados.add(reservaClonado);
		}
		return reservaesClonados;
	}
}
