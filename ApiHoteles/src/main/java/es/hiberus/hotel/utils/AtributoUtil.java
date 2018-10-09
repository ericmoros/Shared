package es.hiberus.hotel.utils;

import java.util.ArrayList;
import java.util.List;

import es.hiberus.hotel.domain.Atributo;

public abstract class AtributoUtil {
	public static Atributo crear() {
		Atributo atributo = new Atributo();
		atributo.setBorrado(false);
		atributo.setNombre("Nombre");
		return atributo;
	}
	
	private static List<Atributo> crearLista(int size) {
		List<Atributo> atributos = new ArrayList<Atributo>();
		Atributo atributo = null;
		for (int i = 0; i < size; i++) {
			atributo = crear();
			atributos.add(atributo);
		}
		return atributos;
	}
	
	public static List<Atributo> crearLista() {
		return crearLista(4);
	}
	

	public static Atributo clonar(Atributo atributo) {
		Atributo atributoClonado = new Atributo();
		atributoClonado.setId(atributo.getId());
		atributoClonado.setNombre(atributo.getNombre());
		atributoClonado.setBorrado(atributo.getBorrado());
		return atributoClonado;
	}
	
	public static List<Atributo> clonarAtributos(List<Atributo> atributos) {
		List<Atributo> atributosClonados = new ArrayList<Atributo>(); 
		Atributo atributoClonado = null;
		for (Atributo atributo : atributos) {
			atributoClonado = clonar(atributo);
			atributosClonados.add(atributoClonado);
		}
		return atributosClonados;
	}
}
