package es.hiberus.hotel.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Servicio;
import es.hiberus.hotel.repository.ServicioRepository;
import es.hiberus.hotel.domain.Hotel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicioRepositoryTests implements IRepositoryTests {
	// Atts
	@Autowired
	private ServicioRepository servicioRepository;
	
	// Methods [private]
	private static Servicio crearServicio() {
		Servicio servicio = new Servicio();
		servicio.setNombre("servicio1");
		
		return servicio;
	}
	
	// Methods [public]
	@Test
	@Override
	public void contextLoads() {
	}

	@Test
	@Override
	public void testCreate() {
		Servicio servicio = crearServicio();
		servicio = servicioRepository.save(servicio);
		Assert.assertNotNull(servicioRepository.findById(servicio.getId()));
	}
	
	@Test
	@Override
	public void testRead() {
		Servicio servicio = crearServicio();
		servicio = servicioRepository.save(servicio);
		Assert.assertNotNull(servicio.getId());
	}
	
	@Test
	@Override
	public void testUpdate() {
		Servicio servicio = crearServicio();
		servicioRepository.save(servicio);
		Servicio servicio2 = servicioRepository.findById(servicio.getId());
		Assert.assertNotNull(servicio2.getId());
		servicio2.setNombre("servicio2");
		servicioRepository.save(servicio2);
		Assert.assertEquals("servicio2", servicioRepository.findById(servicio2.getId()).getNombre());
	}
	
	@Test
	@Override
	public void testDelete() {
		Servicio servicio = crearServicio();
		servicio = servicioRepository.save(servicio);
		
		Assert.assertNotNull(servicio.getId());
		Assert.assertEquals(false, servicio.getBorrado());
		
		servicio.setBorrado(true);
		servicio = servicioRepository.save(servicio);
		Assert.assertTrue(servicio.getBorrado());
		
	}

	@Test
	@Override
	public void testReadAll() {

		servicioRepository.deleteAll();
		
		List<Servicio> listServicios = new ArrayList<>();
		
		for(int i = 0; i<3;i++) {
			Servicio servicio = new Servicio();
			List<Hotel> hoteles = new ArrayList<>();
			Hotel hotel = new Hotel();
			hoteles.add(hotel);
			servicio.setNombre("servicio " + i);
//			servicio.setHoteles(hoteles); // TODO: Pendiente de revisar
			servicioRepository.save(servicio);
			listServicios.add(servicio);
		}
		
		List<Servicio> servicios = servicioRepository.findAll();
		if (servicios.size() < 1) Assert.assertTrue(false);	
		else Assert.assertTrue(servicios.containsAll(listServicios));
	}
	
}
