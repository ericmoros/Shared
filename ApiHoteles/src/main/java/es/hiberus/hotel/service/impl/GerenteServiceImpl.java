package es.hiberus.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.EstadoReserva;
import es.hiberus.hotel.domain.Gerente;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.domain.Reserva;
import es.hiberus.hotel.domain.Servicio;
import es.hiberus.hotel.repository.GerenteRepository;
import es.hiberus.hotel.repository.HabitacionRepository;
import es.hiberus.hotel.repository.ReservaRepository;
import es.hiberus.hotel.repository.ServicioRepository;
import es.hiberus.hotel.service.GerenteService;
import es.hiberus.hotel.utils.ReservaUtil;
import es.hiberus.hotel.utils.ServicioUtil;
@Service
public class GerenteServiceImpl extends UsuarioServiceImpl implements GerenteService {

	@Autowired
	private HabitacionRepository habitacionRepository;

	@Autowired
	private GerenteRepository gerenteRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	@Override
	public Habitacion modificarEstado(Habitacion habitacion, EstadoHabitacion estado) {
		Habitacion returnedHabitacion = null; 
		returnedHabitacion = habitacionRepository.findById(habitacion.getId());
		if(returnedHabitacion != null) {
			returnedHabitacion.setEstado(estado);
			returnedHabitacion = habitacionRepository.save(returnedHabitacion);
		}
		return returnedHabitacion;
	}

	@Override
	public Reserva modificarReserva(Gerente gerente, Reserva reservaActual, Reserva reservaNueva) {
		Hotel gerenteHotel = null;
		Hotel reservaHotel = null;
		Habitacion habitacion = null;
		List<Habitacion> habitaciones = null;
		gerente = gerenteRepository.findById(gerente.getId());
		reservaActual = reservaRepository.findById(reservaActual.getId());
		
		if (gerente != null && reservaActual != null) {
			habitaciones = reservaActual.getHabitaciones();
			if (habitaciones != null) {
				habitacion = habitaciones.get(0);
				gerenteHotel = gerente.getHotel();
				reservaHotel = habitacion.getHotel();
				
				if (gerenteHotel.equals(reservaHotel)) {
					ReservaUtil.copiar(reservaActual, reservaNueva);
					reservaActual = reservaRepository.save(reservaActual);
				}				
			}
		}
		return reservaActual;
	}

	@Override
	public Reserva anularReserva(Reserva reserva) {
		Reserva returnedReserva = null;
		returnedReserva = reservaRepository.findById(reserva.getId());
		if(returnedReserva != null) {
			returnedReserva.setEstado(EstadoReserva.ANULADA);
			returnedReserva = reservaRepository.save(returnedReserva);
		}
		return returnedReserva;
	}

	@Override
	public Reserva confirmarReserva(Reserva reserva) {
		Reserva returnedReserva = null;
		returnedReserva = reservaRepository.findById(reserva.getId());
		if(returnedReserva != null) {
			returnedReserva.setEstado(EstadoReserva.CONFIRMADA);
			returnedReserva = reservaRepository.save(returnedReserva);
		}
		return returnedReserva;
	}

	@Override
	public Servicio crearServicio(Servicio servicio) {
		Servicio returnedServicio = null;
		returnedServicio = servicioRepository.findByNombre(servicio.getNombre());
		if(returnedServicio != null) {
			returnedServicio = servicioRepository.save(returnedServicio);
		}
		return returnedServicio;
	}

	@Override
	public Servicio eliminarServicio(Servicio servicio) {
		Servicio returnedServicio = null;
		returnedServicio = servicioRepository.findByNombre(servicio.getNombre());
		if(returnedServicio != null) {
			returnedServicio.setBorrado(true);
			returnedServicio = servicioRepository.save(returnedServicio);
		}
		return returnedServicio;
	}

	@Override
	public Servicio modificarServicio(Servicio servicioActual, Servicio servicioNuevo) {
		Servicio returnedServicio = null;
		returnedServicio = servicioRepository.findById(servicioActual.getId());
		if(returnedServicio != null && servicioNuevo != null) {
			ServicioUtil.copiar(returnedServicio, servicioNuevo);
			returnedServicio = servicioRepository.save(returnedServicio);
		}
		return returnedServicio;		
	}

}
