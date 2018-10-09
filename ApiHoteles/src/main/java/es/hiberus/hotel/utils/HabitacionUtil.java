package es.hiberus.hotel.utils;

import java.util.ArrayList;
import java.util.List;

import es.hiberus.hotel.domain.Atributo;
import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.domain.TipoHabitacion;

public abstract class HabitacionUtil {
	public static Habitacion crear(Hotel hotel, List<Atributo> atributos) {
		Habitacion habitacion = new Habitacion();
		habitacion.setBorrado(false);
		habitacion.setEstado(EstadoHabitacion.NODISPONIBLE);
		habitacion.setHotel(hotel);
		habitacion.setMetros(1);
		habitacion.setTipo(TipoHabitacion.INDIVIDUAL);
		habitacion.setAtributos(atributos);
		return habitacion;
	}
	
	private static List<Habitacion> crearLista(Hotel hotel, List<Atributo> atributos, Integer size) {
		List<Habitacion> habitacions = new ArrayList<Habitacion>();
		Habitacion habitacion = null;
		for (int i = 0; i < size; i++) {
			habitacion = crear(hotel, atributos);
			habitacions.add(habitacion);
		}
		return habitacions;
	}
	
	public static List<Habitacion> crearLista(Hotel hotel, List<Atributo> atributos) {
		return crearLista(hotel, atributos, 4);
	}

	public static Habitacion clonar(Habitacion habitacion) {
		Habitacion habitacionClonado = new Habitacion();
		habitacionClonado.setBorrado(habitacion.getBorrado());
		habitacionClonado.setEstado(habitacion.getEstado());
		habitacionClonado.setHotel(habitacion.getHotel());
		habitacionClonado.setMetros(habitacion.getMetros());
		habitacionClonado.setTipo(habitacion.getTipo());
		habitacionClonado.setAtributos(habitacion.getAtributos());
		return habitacionClonado;
	}
	
	public static List<Habitacion> clonarHabitaciones(List<Habitacion> habitaciones) {
		List<Habitacion> habitacionsClonados = new ArrayList<Habitacion>(); 
		Habitacion habitacionClonado = null;
		for (Habitacion habitacion : habitaciones) {
			habitacionClonado = clonar(habitacion);
			habitacionsClonados.add(habitacionClonado);
		}
		return habitacionsClonados;
	}
}
