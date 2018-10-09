package es.hiberus.hotel.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Atributo;
import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.domain.Reserva;
import es.hiberus.hotel.domain.Servicio;
import es.hiberus.hotel.utils.AtributoUtil;
import es.hiberus.hotel.utils.ClienteUtil;
import es.hiberus.hotel.utils.HabitacionUtil;
import es.hiberus.hotel.utils.HotelUtil;
import es.hiberus.hotel.utils.ReservaUtil;
import es.hiberus.hotel.utils.ServicioUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservaRepositoryTests implements IRepositoryTests {
	// Atts
	@Autowired
	private ServicioRepository servicioRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private AtributoRepository atributoRepository;

	@Autowired
	private HabitacionRepository habitacionRepository;

	@Autowired
	private ClienteRepository clienteRepository;

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

	private Reserva crearReserva() {
		Reserva reserva = ReservaUtil.crear(habitaciones, cliente);
		reserva = reservaRepository.save(reserva);
		return reserva;
	}

	private List<Reserva> crearReservas() {
		List<Reserva> reservas = ReservaUtil.crearLista(habitaciones, cliente);
		reservas = (List<Reserva>) reservaRepository.saveAll(reservas);
		return reservas;
	}

	// Methods [public]
	@Test
	@Override
	public void contextLoads() {
		poblarDependencias();
	}

	@Test
	@Override
	public void testCreate() {
		Reserva reserva = crearReserva();
		Assert.assertNotNull(reservaRepository.findById(reserva.getId()));
	}

	@Test
	@Override
	public void testRead() {
		Reserva reserva = crearReserva();
		Reserva reservaRead = reservaRepository.save(reserva);
		Assert.assertNotNull(reservaRead.getId());
	}

	@Test
	@Override
	public void testUpdate() {
		Reserva reserva = crearReserva();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Reserva reserva2 = reservaRepository.save(reserva);
		Assert.assertNotNull(reserva2.getId());

		Date datePrin = null;
		try {
			datePrin = format.parse("2009-12-27");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva2.setFechaInicio(datePrin);

		reserva2 = reservaRepository.save(reserva2);
		Assert.assertEquals(reserva2.getFechaInicio(), reservaRepository.findById(reserva2.getId()).getFechaInicio());
	}

	@Test
	@Override
	public void testDelete() {
		Reserva reserva = crearReserva();
		reserva = reservaRepository.save(reserva);

		Assert.assertNotNull(reserva.getId());
		Assert.assertEquals(false, reserva.getBorrado());

		reserva.setBorrado(true);
		reserva = reservaRepository.save(reserva);
		Assert.assertTrue(reserva.getBorrado());
	}

	@Test
	@Override
	public void testReadAll() {
		List<Reserva> listReservas = crearReservas();
		List<Reserva> reservas = reservaRepository.findAll();
		if (reservas.size() < 1) Assert.assertTrue(false);	
		else Assert.assertTrue(reservas.containsAll(listReservas));
	}

}
