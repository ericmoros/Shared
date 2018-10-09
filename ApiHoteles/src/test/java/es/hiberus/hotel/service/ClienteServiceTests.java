package es.hiberus.hotel.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Atributo;
import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.EstadoReserva;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.domain.Reserva;
import es.hiberus.hotel.domain.Servicio;
import es.hiberus.hotel.repository.AtributoRepository;
import es.hiberus.hotel.repository.ClienteRepository;
import es.hiberus.hotel.repository.HabitacionRepository;
import es.hiberus.hotel.repository.HotelRepository;
import es.hiberus.hotel.repository.ReservaRepository;
import es.hiberus.hotel.repository.ServicioRepository;
import es.hiberus.hotel.utils.AtributoUtil;
import es.hiberus.hotel.utils.ClienteUtil;
import es.hiberus.hotel.utils.HabitacionUtil;
import es.hiberus.hotel.utils.HotelUtil;
import es.hiberus.hotel.utils.ReservaUtil;
import es.hiberus.hotel.utils.ServicioUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTests {
	// Atts
	@Autowired
	public ClienteService clienteService;

	@Autowired
	private HabitacionRepository habitacionRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AtributoRepository atributoRepository;

	@Autowired
	private ServicioRepository servicioRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private ReservaRepository reservaRepository;

	// Dependencias
	private List<Servicio> servicios;
	private Hotel hotel;
	private List<Atributo> atributos;
	private List<Habitacion> habitaciones;
	private Cliente cliente;

	// Methods [private]
	public void poblarDependencias() {
		servicios = ServicioUtil.crearLista();
		servicios = (List<Servicio>) servicioRepository.saveAll(servicios);
		hotel = HotelUtil.crear(servicios);
		hotel = hotelRepository.save(hotel);
		atributos = AtributoUtil.crearLista();
		atributos = (List<Atributo>) atributoRepository.saveAll(atributos);
		habitaciones = HabitacionUtil.crearLista(hotel, atributos);
		habitaciones = (List<Habitacion>) habitacionRepository.saveAll(habitaciones);
		cliente = ClienteUtil.crear();
		cliente = clienteRepository.save(cliente);
	}
	
	@Before
	public void limpiarDB() {
		reservaRepository.deleteAll();
		clienteRepository.deleteAll();
		habitacionRepository.deleteAll();
		atributoRepository.deleteAll();
		hotelRepository.deleteAll();
		servicioRepository.deleteAll();
	}

	private Reserva crearReserva() {
		Reserva reserva = ReservaUtil.crear(habitaciones, cliente);
		reserva = reservaRepository.save(reserva);
		return reserva;
	}

//	private List<Reserva> crearReservas() {
//		List<Reserva> reservas = ReservaUtil.crearLista(habitaciones, cliente);
//		reservas = (List<Reserva>) reservaRepository.saveAll(reservas);
//		return reservas;
//	}

	// Methods [public]
	@Test
	public void testReservar() {
		Reserva reserva = crearReserva();
		reserva = clienteService.reservar(reserva);
		Assert.assertNotNull(reserva);
	}

	@Test
	public void testCancelarReserva() {
		Reserva reserva = crearReserva();
		reserva = clienteService.cancelarReserva(reserva);
		Assert.assertEquals(EstadoReserva.ANULADA, reserva.getEstado());

	}

	@Test
	public void testListarHoteles() {
		List<Hotel> hoteles = HotelUtil.crearLista(servicios);
		hoteles = (List<Hotel>) hotelRepository.saveAll(hoteles);
		List<Hotel> hotelesDB = clienteService.listAllHoteles();
		if (hoteles.size() != 0 && hotelesDB.size() != 0) {
			Assert.assertEquals(hoteles.size(), hotelesDB.size());
			Assert.assertTrue(hoteles.containsAll(hotelesDB));
		} else {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testCerrarSesion() {
		Cliente cliente = ClienteUtil.crear();
		cliente.setSesion(true);
		cliente = clienteRepository.save(cliente);
		cliente = clienteService.cerrarSesion(cliente);
		Assert.assertEquals(false, cliente.getSesion());
	}

	@Test
	public void testListarHabitaciones() {
		List<Habitacion> habitaciones = HabitacionUtil.crearLista(hotel, atributos);
		habitaciones = (List<Habitacion>) habitacionRepository.saveAll(habitaciones);
		List<Habitacion> habitacionesDB = (List<Habitacion>) clienteService.listAllHabitaciones();
		if (habitaciones.size() != 0 && habitacionesDB.size() != 0)
			Assert.assertTrue(habitaciones.containsAll(habitacionesDB));
		else
			Assert.assertTrue(true);
	}

	@Test
	public void testListarHabitacionesDisponibles() {
		List<Habitacion> habitacionesOld = null;
		List<Habitacion> habitaciones = HabitacionUtil.crearLista(hotel, atributos);
		habitaciones.forEach(h -> h.setEstado(EstadoHabitacion.LIBRE));
		habitaciones = (List<Habitacion>) habitacionRepository.saveAll(habitaciones);
		habitacionesOld = HabitacionUtil.clonarHabitaciones(habitaciones);
		habitaciones = clienteService.findHabitacionByEstado(EstadoHabitacion.LIBRE);
		for (int i = 0; i < habitaciones.size(); i++) { //TODO: Mejorable
			EstadoHabitacion habitacionOldEstado = habitacionesOld.get(i).getEstado();
			EstadoHabitacion habitacionEstado = habitaciones.get(i).getEstado();
			Assert.assertEquals(habitacionOldEstado, habitacionEstado);
		}
		
	}

}