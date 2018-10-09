package es.hiberus.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.repository.ClienteRepository;
import es.hiberus.hotel.repository.HabitacionRepository;
import es.hiberus.hotel.repository.HotelRepository;
import es.hiberus.hotel.service.PublicoService;

@Service
public class PublicoServiceImpl implements PublicoService {
	// Atts
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	// Methods [public]
	
//	@Override
//	public List<Servicio> listAllServicios(Hotel hotel) {
//		return servicioRepository.findByHotelId(hotel.getId());
//	}
//
//	@Override
//	public List<Reserva> findReservaByCliente(Cliente cliente) {
//		return reservaRepository.findByCliente(cliente);
//	}
	
	@Override
	public List<Hotel> listAllHoteles() {
		return hotelRepository.findAll();
	}

	@Override
	public List<Habitacion> findHabitacionByEstado(EstadoHabitacion estadoHabitacion) {
		return habitacionRepository.findByEstado(estadoHabitacion);
	}

	@Override
	public Cliente iniciarSesion(String nombreCliente, String contrasenia) {
		Cliente cliente = null;
		cliente = clienteRepository.findByNombre(nombreCliente);
		if (cliente != null && cliente.getContrasenia().equals(contrasenia)) {
			cliente.setSesion(true);
			cliente = clienteRepository.save(cliente);
		}
		return cliente;
	}

	@Override
	public Cliente registrarse(Cliente cliente) {
		Cliente rCliente = clienteRepository.findByNombre(cliente.getNombre());
		if (rCliente == null)
			cliente = clienteRepository.save(cliente);
		else
			cliente = null;
		return cliente;
	}

	@Override
	public List<Habitacion> listAllHabitaciones() {
		return null;
	}

}
