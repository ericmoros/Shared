package es.hiberus.hotel.utils;

import es.hiberus.hotel.domain.Administrador;

public abstract class AdministradorUtil {
	
	public static Administrador crear() {
		Administrador administrador= new Administrador();
		administrador.setBorrado(false);
		administrador.setDni("00000000A");
		administrador.setNombre("Nombre");
		return administrador;
	}
	
}
