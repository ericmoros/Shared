package com.hiberus.dual.hotel.modelos.habitacion;

import java.util.Optional;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
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

	public void testRead() {
		Hotel hotel = null;
		Hotel hotelOld = null;
		Optional<Hotel> oHotel = null;

		hotel = new Hotel(1L, EstadoEnum.DESHABILITADO, "A-94834311", "Calle Legumbre", "Hotel Patata");
		hotelOld = new Hotel(hotel);
		hR.save(hotel);
		
		oHotel = hR.findById(hotel.getId());

		if (oHotel.isPresent()) hotel = oHotel.get();
		Assert.assertEquals(hotelOld, hotel);
	}
	
	@Test
	public void testCreate() {
		Hotel hotel = null;
		Hotel hotelOld = null;
		Optional<Hotel> oHotel= null;
		hotel = new Hotel(1L, EstadoEnum.DESHABILITADO, "A-94834311", "Calle Legumbre", "Hotel Patata");
		hR.save(hotel);
		hotelOld = new Hotel(hotel);

		oHotel = hR.findById(hotel.getId());

		if (oHotel.isPresent()) hotel = oHotel.get();
		Assert.assertEquals(hotelOld, hotel);
	}

	@Test
	public void testUpdate() {
		Hotel hotel = null;
		Hotel hotelOld = null;
		Optional<Hotel> oHotel = null;

		hotel = new Hotel(1L, EstadoEnum.DESHABILITADO, "A-94834311", "Calle Legumbre", "Hotel Patata");
		hR.save(hotel);
		
		hotel.setCif("A-94831342");
		hotel.setCalle("Calle Languido");
		hotel.setNombre("Hotel Pepino");
		hR.save(hotel);
		hotelOld = new Hotel(hotel);

		
		oHotel = hR.findById(hotel.getId());

		if (oHotel.isPresent()) hotel = oHotel.get();
		Assert.assertEquals(hotelOld, hotel);
	}

	@Test
	public void testDelete() {
		Hotel hotel = null;
		Optional<Hotel> oHotel = null;

		hotel = new Hotel(1L, EstadoEnum.DESHABILITADO, "A-94831342", "Calle Languido", "Hotel Pepino");
		hotel = hR.save(hotel);
		hR.deleteById(hotel.getId());

		oHotel = hR.findById(hotel.getId());
		Assert.assertTrue(!oHotel.isPresent());
	}
	
	
}
