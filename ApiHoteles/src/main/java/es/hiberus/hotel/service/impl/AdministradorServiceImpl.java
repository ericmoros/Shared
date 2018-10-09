package es.hiberus.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hiberus.hotel.domain.Administrador;
import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.EstadoReserva;
import es.hiberus.hotel.domain.Gerente;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.domain.Reserva;
import es.hiberus.hotel.domain.Servicio;
import es.hiberus.hotel.repository.AdministradorRepository;
import es.hiberus.hotel.repository.ClienteRepository;
import es.hiberus.hotel.repository.GerenteRepository;
import es.hiberus.hotel.repository.HabitacionRepository;
import es.hiberus.hotel.repository.HotelRepository;
import es.hiberus.hotel.repository.ReservaRepository;
import es.hiberus.hotel.repository.ServicioRepository;
import es.hiberus.hotel.service.AdministradorService;
import es.hiberus.hotel.utils.HotelUtil;
import es.hiberus.hotel.utils.ServicioUtil;

@Service
public class AdministradorServiceImpl extends UsuarioServiceImpl implements AdministradorService {

	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private ServicioRepository servicioRepository;

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private GerenteRepository gerenteRepository;

	@Override
	public Gerente asignarHotelGerente(Hotel hotel, Gerente gerente) {
		gerente.setHotel(hotel);
		return gerenteRepository.save(gerente);
	}

	@Override
	public Habitacion darDeAltaHabitacion() {
		Habitacion habitacion = new Habitacion();
		habitacion.setMetros(5);
		return habitacionRepository.save(habitacion);
	}

	@Override
	public void darDeBajaHabitacion(Habitacion habitacion) {
		habitacionRepository.deleteById(habitacion.getId());
	}

	@Override
	public Cliente darDeAltaCliente() {
		Cliente cliente = new Cliente();
		cliente.setNombre("cliente1");
		cliente = clienteRepository.save(cliente) ;
		return cliente;
	}

	@Override
	public void darDeBajaCliente(Cliente cliente) {
		clienteRepository.deleteById(cliente.getId());
	}

	@Override
	public Reserva reservar(Reserva reserva, Cliente cliente) {
		if(reserva.getCliente().equals(cliente)) {
			List<Habitacion> habitaciones = reserva.getHabitaciones();
			for(Habitacion habitacion : habitaciones) {
				if(!habitacion.getHotel().equals(reservaRepository.findHotel())) {
					return reserva;
				}
			}
			return reservaRepository.save(reserva);
		}
		return reserva;
	}

	@Override
	public List<Hotel> listAllHoteles() {
		return hotelRepository.findAll();
	}

	@Override
	public Reserva cancelarReserva(Reserva reserva, Cliente cliente) {
		if(reserva.getCliente().equals(cliente)) {
			reserva.setEstado(EstadoReserva.ANULADA);
			return reservaRepository.save(reserva);
		}
		return reserva;
	}

	@Override
	public Hotel darDeAltaHotel() {
		
		List<Servicio> servicios = ServicioUtil.crearLista();	
		servicios = (List<Servicio>) servicioRepository.saveAll(servicios);
		Hotel hotel = HotelUtil.crear(servicios);
		
		return hotelRepository.save(hotel);
	}

	@Override
	public void darDeBajaHotel(Hotel hotel) {
		hotel.setBorrado(true);
	}

	@Override
	public Administrador cerrarSesion(Administrador administrador) {
		administrador = administradorRepository.findById(administrador.getId());
		if (administrador != null) {
			administrador.setSesion(false);
			administrador = administradorRepository.save(administrador);
		}
		return administrador;
	}

	@Override
	public List<Reserva> findByReserva(Cliente cliente) {
		
		return null;
	}

	@Override
	public List<Habitacion> listAllHabitaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Habitacion> findHabitacionByEstado(EstadoHabitacion estadoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}


}
