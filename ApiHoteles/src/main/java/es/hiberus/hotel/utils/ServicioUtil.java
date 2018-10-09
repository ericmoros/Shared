package es.hiberus.hotel.utils;

import java.util.ArrayList;
import java.util.List;

import es.hiberus.hotel.domain.Servicio;


public abstract class ServicioUtil {
	public static Servicio crear() {
		Servicio servicio = new Servicio();
		servicio.setBorrado(false);
		servicio.setNombre("nombre");
		return servicio;
	}
	
	private static List<Servicio> crearLista(int size) {
		List<Servicio> servicioes = new ArrayList<Servicio>();
		Servicio servicio = null;
		for (int i = 0; i < size; i++) {
			servicio = crear();
			servicioes.add(servicio);
		}
		return servicioes;
	}
	
	public static List<Servicio> crearLista() {
		return crearLista(4);
	}

	public static Servicio clonar(Servicio servicio) {
		Servicio servicioClonado = new Servicio();
		servicioClonado.setId(servicio.getId());
		servicioClonado.setBorrado(servicio.getBorrado());
		servicioClonado.setNombre(servicio.getNombre());
		return servicioClonado;
	}
	
	public static void copiar(Servicio servicioActual, Servicio servicioNuevo) {
		servicioActual.setId(servicioNuevo.getId());
		servicioActual.setBorrado(servicioNuevo.getBorrado());
		servicioActual.setNombre(servicioNuevo.getNombre());
	}
	
	public static List<Servicio> clonarServicios(List<Servicio> servicioes) {
		List<Servicio> servicioesClonados = new ArrayList<Servicio>(); 
		Servicio servicioClonado = null;
		for (Servicio servicio : servicioes) {
			servicioClonado = clonar(servicio);
			servicioesClonados.add(servicioClonado);
		}
		return servicioesClonados;
	}
}
