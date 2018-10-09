package es.hiberus.hotel.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Habitacion;
import es.hiberus.hotel.repository.HabitacionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HabitacionRepositoryTests implements IRepositoryTests {
	// Atts
	@Autowired
	private HabitacionRepository habitacionRepository;

	// Methods [private]
	private static Habitacion crearHabitacion() {
		Habitacion habitacion = new Habitacion();
		habitacion.setMetros(40);
		return habitacion;
	}
	
	// Methods [public]
	public void contextLoads() {
	}
	
	@Test
	@Override
	public void testCreate() {
		Habitacion habitacion = crearHabitacion();
		habitacion = habitacionRepository.save(habitacion);
		Assert.assertNotNull(habitacionRepository.findById(habitacion.getId()));
	}

	@Test
	@Override
	public void testRead() {
		Habitacion habitacion = crearHabitacion();
		Habitacion habitacionRead = habitacionRepository.save(habitacion);
		Assert.assertNotNull(habitacionRead.getId());
	}

	@Test
	@Override
	public void testUpdate() {
		Habitacion habitacion = crearHabitacion();
		Habitacion habitacion2 = habitacionRepository.save(habitacion);
		Assert.assertNotNull(habitacion2.getId());
		habitacion2.setMetros(20);
		habitacion2 = habitacionRepository.save(habitacion2);
		Assert.assertEquals(20, habitacionRepository.findById(habitacion2.getId()).getMetros());
	}

	@Test
	@Override
	public void testDelete() {
		Habitacion habitacion = crearHabitacion();
		habitacion = habitacionRepository.save(habitacion);

		Assert.assertNotNull(habitacion.getId());
		Assert.assertEquals(false, habitacion.getBorrado());

		habitacion.setBorrado(true);
		habitacion = habitacionRepository.save(habitacion);
		Assert.assertTrue(habitacion.getBorrado());
	}

	@Test
	@Override
	public void testReadAll() {

		habitacionRepository.deleteAll();

		List<Habitacion> listHabitaciones = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			Habitacion habitacion = new Habitacion();
			habitacion.setMetros(i * 20);
			habitacionRepository.save(habitacion);
			listHabitaciones.add(habitacion);
		}

		List<Habitacion> hoteles = habitacionRepository.findAll();
		if (hoteles.size() < 1) Assert.assertTrue(false);	
		else Assert.assertTrue(hoteles.containsAll(listHabitaciones));
	}

	
}
