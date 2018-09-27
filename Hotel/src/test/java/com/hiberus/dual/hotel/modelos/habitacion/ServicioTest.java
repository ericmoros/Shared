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
	public void testRead() {
		Servicio servicio = null;
		Servicio servicioOld = null;
		Optional<Servicio> oServicio = null;

		servicio = new Servicio(1L, "Testing");
		servicioOld = new Servicio(servicio);
		sR.save(servicio);
		
		oServicio = sR.findById(servicio.getId());

		if (oServicio.isPresent()) servicio = oServicio.get();
		Assert.assertEquals(servicioOld, servicio);
	}
	
	@Test
	public void testCreate() {
		Servicio servicio = null;
		servicio = new Servicio(1L, "Testing");
		sR.save(servicio);
	}

	@Test
	public void testUpdate() {
		Servicio servicio = null;
		Servicio servicioOld = null;
		Optional<Servicio> oServicio = null;

		servicio = new Servicio(1L, "Testing");
		sR.save(servicio);
		
		servicio.setNombre("Testing2");
		sR.save(servicio);
		servicioOld = new Servicio(servicio);

		
		oServicio = sR.findById(servicio.getId());

		if (oServicio.isPresent()) servicio = oServicio.get();
		Assert.assertEquals(servicioOld, servicio);
	}

	@Test
	public void testDelete() {
		Servicio servicio = null;
		Optional<Servicio> oServicio = null;

		servicio = new Servicio(1L, "Testing");
		servicio = sR.save(servicio);
		sR.deleteById(servicio.getId());

		oServicio = sR.findById(servicio.getId());
		Assert.assertTrue(!oServicio.isPresent());
	}

	
}
