package com.hiberus.dual.hotel.modelos.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

	@Test
	public void testRead() {
		Hotel hotel = null;
		Hotel hotelOld = null;
		Optional<Hotel> oHotel = null;

		hotel = new Hotel(1L, EstadoEnum.DESHABILITADO, "A-94834311", "Calle Legumbre", "Hotel Patata", null);
		hotelOld = new Hotel(hotel);
		hR.save(hotel);
		
		oHotel = hR.findById(hotel.getId());

		if (oHotel.isPresent()) hotel = oHotel.get();
		Assert.assertEquals(hotelOld, hotel);
	}

	@Test
	public void testReadAll() { // El test individual no funciona.
		hR.deleteAll();
		List<Hotel> hoteles = null;
		List<Hotel> hotelesOld = null;

		hoteles = new ArrayList<Hotel>(
			Arrays.asList(
				new Hotel[] {
					new Hotel().estado(EstadoEnum.DESHABILITADO).nombre("Hotel Patata").calle("Legumbre").cif("A-94834311").servicios(null),
					new Hotel().estado(EstadoEnum.DESHABILITADO).nombre("Hotel Patata2").calle("Legumbre").cif("A-94834312").servicios(null),
					new Hotel().estado(EstadoEnum.DESHABILITADO).nombre("Hotel Patata3").calle("Legumbre").cif("A-94834313").servicios(null),
					new Hotel().estado(EstadoEnum.DESHABILITADO).nombre("Hotel Patata4").calle("Legumbre").cif("A-94834314").servicios(null),
					new Hotel().estado(EstadoEnum.DESHABILITADO).nombre("Hotel Patata5").calle("Legumbre").cif("A-94834315").servicios(null)
				}
			)
		);
		hotelesOld = (List<Hotel>) hR.saveAll(hoteles);

		hoteles = (List<Hotel>) hR.findAll();
		Assert.assertEquals(hotelesOld, hoteles);
		
	}
	
	@Test
	public void testCreate() {
		Hotel hotel = null;
		Hotel hotelOld = null;
		Optional<Hotel> oHotel= null;
		hotel = new Hotel(1L, EstadoEnum.DESHABILITADO, "A-94834311", "Calle Legumbre", "Hotel Patata", null);
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

		hotel = new Hotel(1L, EstadoEnum.DESHABILITADO, "A-94834311", "Calle Legumbre", "Hotel Patata", null);
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

		hotel = new Hotel(1L, EstadoEnum.DESHABILITADO, "A-94834311", "Calle Legumbre", "Hotel Patata", null);
		hR.save(hotel);

		hotel.setEstado(EstadoEnum.BORRADO);
		hR.save(hotel);
		
		oHotel = hR.findById(hotel.getId());

		if (oHotel.isPresent()) hotel = oHotel.get();
		Assert.assertEquals(EstadoEnum.BORRADO, hotel.getEstado());
	}
	
	
}
