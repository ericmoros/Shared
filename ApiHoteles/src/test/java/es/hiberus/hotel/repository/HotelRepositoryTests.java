package es.hiberus.hotel.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.repository.HotelRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelRepositoryTests implements IRepositoryTests {
	// Atts
	@Autowired
	private HotelRepository hotelRepository;

	// Methods [private]
	private static Hotel crearHotel() {
		Hotel hotel = new Hotel();
		hotel.setCif("cif1");
		hotel.setNombre("hotel1");
		hotel.setCalle("calle1");
		hotel.setValoracion(5);
		hotel.setServicios(null);
		return hotel;
	}

	// Methods [public]
	@Test
	@Override
	public void contextLoads() {
	}

	@Test
	@Override
	public void testCreate() {
		Hotel hotel = crearHotel();
		hotel = hotelRepository.save(hotel);
		Assert.assertNotNull(hotelRepository.findById(hotel.getId()));
	}

	@Test
	@Override
	public void testRead() {
		Hotel hotel = crearHotel();
		Hotel hotelRead = hotelRepository.save(hotel);
		Assert.assertNotNull(hotelRead.getId());
	}

	@Test
	@Override
	public void testUpdate() {
		Hotel hotel = crearHotel();
		Hotel hotel2 = hotelRepository.save(hotel);
		Assert.assertNotNull(hotel2.getId());
		hotel2.setNombre("hotel2");
		hotel2 = hotelRepository.save(hotel2);
		Assert.assertEquals("hotel2", hotelRepository.findById(hotel2.getId()).getNombre());
	}

	@Test
	@Override
	public void testDelete() {
		Hotel hotel = crearHotel();
		hotel = hotelRepository.save(hotel);

		Assert.assertNotNull(hotel.getId());
		Assert.assertEquals(false, hotel.getBorrado());

		hotel.setBorrado(true);
		hotel = hotelRepository.save(hotel);
		Assert.assertTrue(hotel.getBorrado());
	}

	@Test
	@Override
	public void testReadAll() {
		List<Hotel> listHoteles = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			Hotel hotel = crearHotel();
			hotelRepository.save(hotel);
			listHoteles.add(hotel);
		}

		List<Hotel> hoteles = hotelRepository.findAll();
		
		if (hoteles.size() < 1) Assert.assertTrue(false);	
		else Assert.assertTrue(hoteles.containsAll(listHoteles));
	}

	
}
