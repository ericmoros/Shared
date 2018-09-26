package com.hiberus.dual.hotel.modelos.habitacion;

import java.math.BigDecimal;
import java.util.Optional;

import com.hiberus.dual.hotel.repositorios.ExtraRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtraTest {
	@Autowired
	private ExtraRepositorio eR;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Extra extra = new Extra();
		Optional<Extra> oRExtra = null;
		Extra rExtra = null;

		extra.setId(1L);
		extra.setNombre("Testing");
		extra.setPrecio(new BigDecimal("1").setScale(2, BigDecimal.ROUND_UP));
		eR.save(extra);

		oRExtra = eR.findById(extra.getId());
		if (oRExtra.isPresent()) rExtra = oRExtra.get();
		
		Assert.assertNotNull(extra.getId());
		Assert.assertEquals((Long)1L, rExtra.getId());
		Assert.assertEquals("Testing", rExtra.getNombre());
		Assert.assertEquals(new BigDecimal("1").setScale(2, BigDecimal.ROUND_UP), rExtra.getPrecio());
	}

	@Test
	public void testUpdate() {
		Extra extra = new Extra();
		Optional<Extra> oRExtra = null;
		Extra rExtra = null;

		extra.setId(1L);
		extra.setNombre("Testing");
		extra.setPrecio(new BigDecimal("1").setScale(2, BigDecimal.ROUND_UP));
		eR.save(extra);
		
		extra.setId(2L);
		extra.setNombre("Testing2");
		extra.setPrecio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		eR.save(extra);

		oRExtra = eR.findById(extra.getId());
		if (oRExtra.isPresent())
			rExtra = oRExtra.get();
		Assert.assertNotNull(extra.getId());
		Assert.assertEquals((Long) 2L, rExtra.getId());
		Assert.assertEquals("Testing2", rExtra.getNombre());
		Assert.assertEquals(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP), rExtra.getPrecio());
	}

	
}
