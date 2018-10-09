package es.hiberus.hotel.utils;

import java.util.ArrayList;
import java.util.List;

import es.hiberus.hotel.domain.Gerente;

public abstract class GerenteUtil extends ClienteUtil {

	public static Gerente crear() {
		Gerente gerente= new Gerente();
		gerente.setBorrado(false);
		gerente.setDni("00000000A");
		gerente.setNombre("Nombre");
		return gerente;
	}
	
	private Gerente clonarGerente(Gerente gerente) {
		Gerente gerenteClonado = new Gerente();
		gerenteClonado.setId(gerente.getId());
		gerenteClonado.setBorrado(gerente.getBorrado());
		// gerenteClonado.setDni(gerente.getDni());
		gerenteClonado.setNombre(gerente.getNombre());
		// gerenteClonado.setReservas(gerente.getReservas());
		return gerenteClonado;
	}

	private List<Gerente> clonarGerentes(List<Gerente> gerentes) {
		List<Gerente> gerentesClonados = new ArrayList<Gerente>();
		Gerente gerenteClonado = null;
		for (Gerente gerente : gerentes) {
			gerenteClonado = clonarGerente(gerente);
			gerentesClonados.add(gerenteClonado);
		}
		return gerentesClonados;
	}
	
}
