package com.hiberus.dual.hotel.modelos.habitacion;

import java.util.Optional;

import com.hiberus.dual.hotel.modelos.hotel.Hotel;
import com.hiberus.dual.hotel.repositorios.HotelRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelTest {
	@Autowired
	private HotelRepositorio hR;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Hotel hotel = new Hotel();
		Optional<Hotel> oHotel = null;
		Hotel rHotel = null;

		hotel.setId(1L);
        hotel.setCif("A-94834311");
        hotel.setCalle("Calle Legumbre");
        hotel.setNombre("Hotel Patata");
		hR.save(hotel);

		oHotel = hR.findById(hotel.getId());
		if (oHotel.isPresent()) rHotel = oHotel.get();
		
		Assert.assertNotNull(hotel.getId());
        Assert.assertEquals((Long)1L, rHotel.getId());
        Assert.assertEquals("A-94834311", rHotel.getCif());
        Assert.assertEquals("Calle Legumbre", rHotel.getCalle());
		Assert.assertEquals("Hotel Patata", rHotel.getNombre());
	}

	@Test
	public void testUpdate() {
		Hotel hotel = new Hotel();
		Optional<Hotel> oHotel = null;
		Hotel rHotel = null;

		hotel.setId(1L);
        hotel.setCif("A-94834311");
        hotel.setCalle("Calle Legumbre");
        hotel.setNombre("Hotel Patata");
		hR.save(hotel);
		
		hotel.setId(1L);
		hotel.setCif("A-94809831");
        hotel.setCalle("Calle Languido");
        hotel.setNombre("Hotel Pepino");
		hR.save(hotel);

		oHotel = hR.findById(hotel.getId());
		if (oHotel.isPresent())
        rHotel = oHotel.get();
		Assert.assertNotNull(hotel.getId());
        Assert.assertEquals((Long) 1L, rHotel.getId());
        Assert.assertEquals("A-94809831", rHotel.getCif());
        Assert.assertEquals("Calle Languido", rHotel.getCalle());
		Assert.assertEquals("Hotel Pepino", rHotel.getNombre());
	}

	// @Test
	// public void testDelete() {
	// 	Hotel hotel = new Hotel();
	// 	Optional<Hotel> oHotel = null;

	// 	hotel.setId(9999L);
	// 	hotel.setNombre("Testing");
	// 	hR.save(hotel);

	// 	hR.delete(hotel);
	// 	oHotel = hR.findById(hotel.getId());
	// 	Assert.assertTrue(!oHotel.isPresent());
	// }

	
}