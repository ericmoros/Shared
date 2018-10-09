package es.hiberus.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
import es.hiberus.hotel.repository.GerenteRepository;
import es.hiberus.hotel.repository.HabitacionRepository;
import es.hiberus.hotel.repository.HotelRepository;
import es.hiberus.hotel.repository.ReservaRepository;
import es.hiberus.hotel.repository.ServicioRepository;
import es.hiberus.hotel.utils.AtributoUtil;
import es.hiberus.hotel.utils.ClienteUtil;
import es.hiberus.hotel.utils.GerenteUtil;
import es.hiberus.hotel.utils.HabitacionUtil;
import es.hiberus.hotel.utils.HotelUtil;
import es.hiberus.hotel.utils.ReservaUtil;
import es.hiberus.hotel.utils.ServicioUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GerenteServiceTests {

	@Autowired
	public GerenteService gerenteService;

	@Autowired
	private GerenteRepository gerenteRepository;

	@Autowired
	private AdministradorRepository administradorRepository;

	@Autowired
	private HabitacionRepository habitacionRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private ServicioRepository servicioRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AtributoRepository atributoRepository;

	@Autowired
	private ReservaRepository reservaRepository;

	private void limpiarDB() {
		reservaRepository.deleteAll();
		administradorRepository.deleteAll();
		clienteRepository.deleteAll();
		habitacionRepository.deleteAll();
		atributoRepository.deleteAll();
		hotelRepository.deleteAll();
		servicioRepository.deleteAll();
	}

	@Test
	public void testCambiarEstadoHabitaciones() {
		
		limpiarDB();
		
		Habitacion habitacion = new Habitacion();
		habitacion = habitacionRepository.save(habitacion);
		Assert.assertNotNull(habitacion.getId());
		gerenteService.modificarEstado(habitacion);
		habitacion = habitacionRepository.save(habitacion);
		Assert.assertEquals("OCUPADO", habitacion.getEstado().toString());
			
	}

	@Test
	public void testListarHoteles() {
		
		limpiarDB();
		
		List<Hotel> hotels = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			Hotel hotel = new Hotel();
			hotel.setNombre("hotel " + i );
			hotel.setCalle("calle " + i );
			hotel.setCif("cif " + i );
			hotels.add(hotel);
			hotelRepository.save(hotel);
		}
		
		List<Hotel> hoteles = gerenteService.listAllHoteles();
		Assert.assertEquals(hotels.size(), hoteles.size());
		Assert.assertTrue(hoteles.containsAll(hotels));
	}
	
	@Test
	public void testListarHabitaciones() {
		
		limpiarDB();
		
		List<Habitacion> habitacions = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			Habitacion habitacion = new Habitacion();
			habitacion.setMetros(i);
			habitacion.setEstado(EstadoHabitacion.LIBRE);
			habitacions.add(habitacion);
			habitacionRepository.save(habitacion);
		}
		
		List<Habitacion> habitaciones = gerenteService.ListarHabitaciones();
		Assert.assertEquals(habitacions.size(), habitaciones.size());
		Assert.assertTrue(habitaciones.containsAll(habitacions));
	}

	@Test
	public void testListarHabitacionesDisponibles() {
		
		limpiarDB();
		
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
	public void testReservar() {

		limpiarDB();

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
		Gerente gerente = GerenteUtil.crear();
		gerente = gerenteRepository.save(gerente);
		reserva = gerenteService.reservar(reserva, gerente);
		Assert.assertNotNull(reserva);
	}

	@Test
	public void testCancelarReserva() {

		limpiarDB();

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
		Gerente gerente = GerenteUtil.crear();
		gerente = gerenteRepository.save(gerente);
		reserva = gerenteService.reservar(reserva, gerente);

		Assert.assertNotNull(reserva);

		reserva = gerenteService.cancelarReserva(reserva, gerente);
		Assert.assertEquals(EstadoReserva.ANULADA, reserva.getEstado());

	}
	
	@Test
	public void testCrearServicio() { // TODO: a servicios

		limpiarDB();
		
		Servicio servicio = ServicioUtil.crear();
		servicio = servicioRepository.save(servicio);
		
		Assert.assertNotNull(servicio);
	}
	
	@Test
	public void testBorrarServicio() { // TODO: a servicios
		
		limpiarDB();
		
		Servicio servicio = ServicioUtil.crear();
		servicio = servicioRepository.save(servicio);
		
		Assert.assertNotNull(servicio);
		
		servicioRepository.deleteById(servicio.getId());
	}
	 
	@Test
	public void testModificarServicio() { // TODO: a servicios
		
		limpiarDB();
		
		Servicio servicio = ServicioUtil.crear();
		servicio = servicioRepository.save(servicio);
		
		Assert.assertNotNull(servicio);
		
		Servicio servicio2 = servicioRepository.findById(servicio.getId());
		servicio2.setNombre("servicio modificado");
		servicio2 = servicioRepository.save(servicio2);
		
		Assert.assertNotEquals(servicio.getNombre(), servicio2.getNombre());
		
	}

}
