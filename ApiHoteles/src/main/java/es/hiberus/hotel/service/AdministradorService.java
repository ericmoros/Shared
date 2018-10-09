package es.hiberus.hotel.service;


import org.springframework.stereotype.Service;

import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.Gerente;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;

@Service
public interface AdministradorService extends UsuarioService{

	Gerente asignarHotelGerente(Hotel hotel, Gerente gerente);
	
	Habitacion darDeAltaHabitacion();
	
	void darDeBajaHabitacion(Habitacion habitacion);

	Cliente darDeAltaCliente();

	void darDeBajaCliente(Cliente cliente);

	Hotel darDeAltaHotel();
	
	void darDeBajaHotel(Hotel hotel);

}
