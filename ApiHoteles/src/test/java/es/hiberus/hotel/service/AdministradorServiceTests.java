package es.hiberus.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Administrador;
import es.hiberus.hotel.domain.Atributo;
import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.EstadoReserva;
import es.hiberus.hotel.domain.Gerente;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.domain.Reserva;
import es.hiberus.hotel.domain.Servicio;
import es.hiberus.hotel.repository.AdministradorRepository;
import es.hiberus.hotel.repository.AtributoRepository;
import es.hiberus.hotel.repository.ClienteRepository;
import es.hiberus.hotel.repository.HabitacionRepository;
import es.hiberus.hotel.repository.HotelRepository;
import es.hiberus.hotel.repository.ReservaRepository;
import es.hiberus.hotel.repository.ServicioRepository;
import es.hiberus.hotel.utils.AdministradorUtil;
import es.hiberus.hotel.utils.AtributoUtil;
import es.hiberus.hotel.utils.ClienteUtil;
import es.hiberus.hotel.utils.GerenteUtil;
import es.hiberus.hotel.utils.HabitacionUtil;
import es.hiberus.hotel.utils.HotelUtil;
import es.hiberus.hotel.utils.ReservaUtil;
import es.hiberus.hotel.utils.ServicioUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministradorServiceTests {
	
	@Autowired
	public AdministradorService administradorService;

	@Autowired
	private AdministradorRepository administradorRepository;

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
	
	@Before
	public void limpiarDB() {
		reservaRepository.deleteAll();
		administradorRepository.deleteAll();
		clienteRepository.deleteAll();
		habitacionRepository.deleteAll();
		atributoRepository.deleteAll();
		hotelRepository.deleteAll();
		servicioRepository.deleteAll();
	}
	
	@Test
	public void testDarAltaCliente() {
		
		Cliente cliente = administradorService.darDeAltaCliente();
		Assert.assertNotNull(cliente);
		Assert.assertNotNull(cliente.getId());
	}
	
	@Test
	public void testDarBajaCliente() {
		
		Cliente cliente = administradorService.darDeAltaCliente();
		Assert.assertNotNull(cliente.getId());
		administradorService.darDeBajaCliente(cliente);
	}
	
	@Test
	public void testDarAltaHabitacion() {
		
		Habitacion habitacion = administradorService.darDeAltaHabitacion();
		habitacion = habitacionRepository.save(habitacion);
		Assert.assertNotNull(habitacionRepository.findById(habitacion.getId()));
	}
	
	@Test
	public void testDarBajaHabitacion() {
		
		Habitacion habitacion = administradorService.darDeAltaHabitacion();
		Assert.assertNotNull(habitacion.getId());
		administradorService.darDeBajaHabitacion(habitacion);
	}

	@Test
	public void testReservar() {
		
		List<Servicio> servicios = ServicioUtil.crearLista();	
		servicioRepository.saveAll(servicios);
		Hotel hotel = HotelUtil.crear(servicios);
		hotelRepository.save(hotel);
		List<Atributo> atributos = AtributoUtil.crearLista();
		atributoRepository.saveAll(atributos);
		List<Habitacion> habitaciones = HabitacionUtil.crearLista(hotel, atributos);
		habitacionRepository.saveAll(habitaciones);
		Cliente cliente = ClienteUtil.crear();
		clienteRepository.save(cliente);
		Reserva reserva = ReservaUtil.crear(habitaciones, cliente);
		reserva = reservaRepository.save(reserva);
		Administrador admin = AdministradorUtil.crear();
		admin = administradorRepository.save(admin);
		reserva = administradorService.reservar(reserva, admin);
		Assert.assertNotNull(reserva);
	}
	
	@Test
	public void testCancelarReserva() {
		
		List<Servicio> servicios = ServicioUtil.crearLista();	
		servicioRepository.saveAll(servicios);
		Hotel hotel = HotelUtil.crear(servicios);
		hotelRepository.save(hotel);
		List<Atributo> atributos = AtributoUtil.crearLista();
		atributoRepository.saveAll(atributos);
		List<Habitacion> habitaciones = HabitacionUtil.crearLista(hotel, atributos);
		habitacionRepository.saveAll(habitaciones);
		Cliente cliente = ClienteUtil.crear();
		clienteRepository.save(cliente);
		Reserva reserva = ReservaUtil.crear(habitaciones, cliente);
		reserva = reservaRepository.save(reserva);
		Administrador admin = AdministradorUtil.crear();
		admin = administradorRepository.save(admin);
		reserva = administradorService.reservar(reserva, admin);
		
		Assert.assertNotNull(reserva);
		
		reserva = administradorService.cancelarReserva(reserva, admin);
		Assert.assertEquals(EstadoReserva.ANULADA, reserva.getEstado());
		
	}
	
	@Test
	public void testListarHoteles() {
		
		List<Hotel> hotels = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			Hotel hotel = new Hotel();
			hotel.setNombre("hotel " + i );
			hotel.setCalle("calle " + i );
			hotel.setCif("cif " + i );
			hotels.add(hotel);
			hotelRepository.save(hotel);
		}
		
		List<Hotel> hoteles = administradorService.listAllHoteles();
		Assert.assertEquals(hotels.size(), hoteles.size());
		Assert.assertTrue(hoteles.containsAll(hotels));
	}
	
	@Test
	public void testListarHabitaciones() {
		
		List<Habitacion> habitacions = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			Habitacion habitacion = new Habitacion();
			habitacion.setMetros(i);
			habitacion.setEstado(EstadoHabitacion.LIBRE);
			habitacions.add(habitacion);
			habitacionRepository.save(habitacion);
		}
		
		List<Habitacion> habitaciones = habitacionRepository.findAll();
		Assert.assertEquals(habitacions.size(), habitaciones.size());
		Assert.assertTrue(habitaciones.containsAll(habitacions));
	}

	@Test
	public void testListarHabitacionesDisponibles() {
		
		List<Habitacion> habitacions = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			Habitacion habitacion = new Habitacion();
			habitacion.setMetros(i);
			habitacion.setEstado(EstadoHabitacion.LIBRE);
			habitacions.add(habitacion);
			habitacionRepository.save(habitacion);
		}
		
		List<Habitacion> habitaciones = habitacionRepository.findAll();
		
		Assert.assertEquals(habitacions.size(), habitaciones.size());
		Assert.assertTrue(habitaciones.containsAll(habitacions));
		
		List<Habitacion> habitacionesDisponibles = new ArrayList<>();
		for(Habitacion habitacion : habitaciones) {
			if(habitacion.getEstado().equals(EstadoHabitacion.LIBRE)) {
				habitacionesDisponibles.add(habitacion);
			}
		}
		
		for(Habitacion habitacion : habitacionesDisponibles) {
			Assert.assertEquals(EstadoHabitacion.LIBRE, habitacion.getEstado());
		}
	}
	
	@Test
	public void testCrearHotel() {
		
		Hotel hotel = administradorService.darDeAltaHotel();
		
		Assert.assertNotNull(hotel);
	}
	
	@Test
	public void testBorrarHotel() {
		
		Hotel hotel = administradorService.darDeAltaHotel();
		
		Assert.assertNotNull(hotel);
				
		administradorService.darDeBajaHotel(hotel);
		
		Assert.assertEquals(hotel.getBorrado(), true);
	}
	
	@Test
	public void testCambiarGerente() {
		
		Hotel hotel = administradorService.darDeAltaHotel();
		Assert.assertNotNull(hotel);
		
		Gerente gerente = GerenteUtil.crear();
		Assert.assertNotNull(gerente);
		
		gerente = administradorService.asignarHotelGerente(hotel, gerente);
		Assert.assertNotNull(gerente.getHotel());
		
		Gerente gerente2 = GerenteUtil.crear();
		Assert.assertNotNull(gerente2);
		
		gerente2 = administradorService.asignarHotelGerente(gerente.getHotel(), gerente2);
		Assert.assertNotNull(gerente2.getHotel());
		
		gerente = administradorService.asignarHotelGerente(null, gerente);
		Assert.assertNull(gerente.getHotel());
		Assert.assertNotEquals(gerente2.getHotel(), gerente.getHotel());
				
	}
	
}