package es.hiberus.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hiberus.hotel.domain.Administrador;
import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.EstadoReserva;
import es.hiberus.hotel.domain.Gerente;
import es.hiberus.hotel.domain.Reserva;
import es.hiberus.hotel.repository.AdministradorRepository;
import es.hiberus.hotel.repository.ClienteRepository;
import es.hiberus.hotel.repository.GerenteRepository;
import es.hiberus.hotel.repository.ReservaRepository;
import es.hiberus.hotel.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AdministradorRepository administradorRepository;

	@Autowired
	private GerenteRepository gerenteRepository;

	@Override
	public Reserva reservar(Reserva reserva) {
		Reserva returnedReserva = null;
		returnedReserva = reservaRepository.findById(reserva.getId());
		if (returnedReserva != null) {
			returnedReserva.setEstado(EstadoReserva.PENDIENTE);
			returnedReserva = reservaRepository.save(returnedReserva);
		}
		return returnedReserva;
	}

	@Override
	public Reserva cancelarReserva(Reserva reserva, Cliente cliente) {
		String claseCliente = cliente.getClass().toString();
		Reserva returnedReserva = null;
		Cliente returnedCliente = null;
		returnedCliente = clienteRepository.findById(cliente.getId());
		returnedReserva = reservaRepository.findById(reserva.getId());
		if (returnedReserva != null && returnedCliente != null) {
			switch (claseCliente) {
			case "es.hiberus.hotel.domain.Gerente":		
				if (returnedCliente.equals(returnedReserva.getCliente())) {
					returnedReserva.setEstado(EstadoReserva.ANULADA);
					returnedReserva = reservaRepository.save(returnedReserva);
				}
				break; // TODO: aclararnos con esta puta mierda por favor :DDDDDDDDDD
				
			default:
				if (returnedCliente.equals(returnedReserva.getCliente())) {
					returnedReserva.setEstado(EstadoReserva.ANULADA);
					returnedReserva = reservaRepository.save(returnedReserva);
				}
				
				break;
			}
		}
		return returnedReserva;
	}

	@Override
	public Cliente cerrarSesion(Cliente cliente) {
		String claseCliente = cliente.getClass().toString();	
		Cliente returnedCliente = null;
		returnedCliente = clienteRepository.findById(cliente.getId());	

		switch (claseCliente) {
		case "es.hiberus.hotel.domain.Cliente":
			returnedCliente = clienteRepository.findById(cliente.getId());
			if (returnedCliente != null) {
				returnedCliente .setSesion(false);
				returnedCliente = clienteRepository.save(returnedCliente);
			}
			
			break;

		case "es.hiberus.hotel.domain.Administrador":
			returnedCliente = administradorRepository.findById(cliente.getId());
			if (returnedCliente != null) {
				returnedCliente.setSesion(false);
				returnedCliente = administradorRepository.save((Administrador) returnedCliente);
			}
			break;

		case "es.hiberus.hotel.domain.Gerente":	
			returnedCliente = gerenteRepository.findById(cliente.getId());
			if (returnedCliente != null) {
				returnedCliente.setSesion(false);
				returnedCliente = gerenteRepository.save((Gerente) returnedCliente);
			}
			break;
		}
		
		return returnedCliente;
	}

	@Override
	public List<Reserva> findByReserva(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
