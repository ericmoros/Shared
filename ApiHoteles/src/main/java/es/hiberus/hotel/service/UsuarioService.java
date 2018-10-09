package es.hiberus.hotel.service;

import java.util.List;

import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.Reserva;

public interface UsuarioService  {
	
	Reserva reservar(Reserva reserva);
	
	Reserva cancelarReserva(Reserva reserva, Cliente cliente);

	Cliente cerrarSesion(Cliente cliente);
	
	List<Reserva> findByReserva(Cliente cliente);
	
}
