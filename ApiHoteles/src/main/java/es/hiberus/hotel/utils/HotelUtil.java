package es.hiberus.hotel.utils;

import java.util.ArrayList;
import java.util.List;

import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.domain.Servicio;

public abstract class HotelUtil {
	public static Hotel crear(List<Servicio> servicios) {
		Hotel hotel = new Hotel();
		hotel.setBorrado(false);
		hotel.setNombre("Nombre");
		hotel.setCif("A00000000");
		hotel.setCalle("No calle");
		hotel.setServicios(servicios);
		return hotel;
	}
	
	private static List<Hotel> crearLista(List<Servicio> servicios, Integer size) {
		List<Hotel> hoteles = new ArrayList<Hotel>();
		Hotel hotel = null;
		for (int i = 0; i < size; i++) {
			hotel = crear(servicios);
			hoteles.add(hotel);
		}
		return hoteles;
	}
	
	public static List<Hotel> crearLista(List<Servicio> servicios) {
		return crearLista(servicios, 4);
	}
	

	public static Hotel clonar(Hotel hotel) {
		Hotel hotelClonado = new Hotel();
		hotelClonado.setId(hotel.getId());
		hotelClonado.setBorrado(hotel.getBorrado());
		hotelClonado.setNombre(hotel.getNombre());
		hotelClonado.setCif(hotel.getCif());
		hotelClonado.setCalle(hotel.getCalle());
		hotelClonado.setServicios(hotel.getServicios());
		return hotelClonado;
	}
	
	public static List<Hotel> clonarHotels(List<Hotel> hoteles) {
		List<Hotel> hotelesClonados = new ArrayList<Hotel>(); 
		Hotel hotelClonado = null;
		for (Hotel hotel : hoteles) {
			hotelClonado = clonar(hotel);
			hotelesClonados.add(hotelClonado);
		}
		return hotelesClonados;
	}
}
