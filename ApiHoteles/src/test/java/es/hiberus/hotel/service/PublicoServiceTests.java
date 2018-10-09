package es.hiberus.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.repository.ClienteRepository;
import es.hiberus.hotel.repository.HabitacionRepository;
import es.hiberus.hotel.repository.HotelRepository;
import es.hiberus.hotel.utils.ClienteUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicoServiceTests {
	
	@Autowired
	public PublicoService publicoService;
	
	@Autowired
	public HotelRepository hotelRepository;

	@Autowired
	public HabitacionRepository habitacionRepository;

	@Autowired
	public ClienteRepository clienteRepository;
	
	private void limpiarDB() {
		hotelRepository.deleteAll();
		habitacionRepository.deleteAll();
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
		
		List<Hotel> hoteles = publicoService.listAllHoteles();
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
		
		List<Habitacion> habitaciones = habitacionRepository.findAll();
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
	public void testLogIn() {
		Cliente cliente = ClienteUtil.crear();
		
		cliente = clienteRepository.save(cliente);
		
		cliente = publicoService.iniciarSesion("Nombre", "Contrasenia");
		
		Assert.assertNotNull(cliente.getContrasenia());
	}
	
	@Test
	public void testRegister() {
		Cliente cliente = ClienteUtil.crear();
		cliente.setNombre("nuevo");
		
		cliente = publicoService.registrarse(cliente);
		
		Assert.assertNotNull(cliente);
	}
	
}