package com.hiberus.dual.hotel.modelos.habitacion;

import java.util.Optional;

import com.hiberus.dual.hotel.modelos.hotel.Servicio;
import com.hiberus.dual.hotel.repositorios.ServicioRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicioTest {
	@Autowired
	private ServicioRepositorio sR;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Servicio servicio = new Servicio();
		Optional<Servicio> oServicio = null;
		Servicio rServicio = null;

		servicio.setId(1L);
		servicio.setNombre("Testing");
		sR.save(servicio);

		oServicio = sR.findById(servicio.getId());
		if (oServicio.isPresent()) rServicio = oServicio.get();
		
		Assert.assertNotNull(servicio.getId());
		Assert.assertEquals((Long)1L, rServicio.getId());
		Assert.assertEquals("Testing", rServicio.getNombre());
	}

	@Test
	public void testUpdate() {
		Servicio servicio = new Servicio();
		Optional<Servicio> oServicio = null;
		Servicio rServicio = null;

		servicio.setId(1L);
		servicio.setNombre("Testing");
		sR.save(servicio);
		
		servicio.setId(2L);
		servicio.setNombre("Testing2");
		sR.save(servicio);

		oServicio = sR.findById(servicio.getId());
		if (oServicio.isPresent())
        rServicio = oServicio.get();
		Assert.assertNotNull(servicio.getId());
		Assert.assertEquals((Long) 2L, rServicio.getId());
		Assert.assertEquals("Testing2", rServicio.getNombre());
	}

	// @Test
	// public void testDelete() {
	// 	Servicio servicio = new Servicio();
	// 	Optional<Servicio> oServicio = null;

	// 	servicio.setId(9999L);
	// 	servicio.setNombre("Testing");
	// 	sR.save(servicio);

	// 	sR.delete(servicio);
	// 	oServicio = sR.findById(servicio.getId());
	// 	Assert.assertTrue(!oServicio.isPresent());
	// }

	
}