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
	public void testRead() {
		Extra extra = null;
		Extra extraOld = null;
		Optional<Extra> oExtra = null;

		extra = new Extra(1L, "Testing", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		extraOld = new Extra(extra);
		eR.save(extra);
		
		oExtra = eR.findById(extra.getId());

		if (oExtra.isPresent()) extra = oExtra.get();
		Assert.assertEquals(extraOld, extra);
	}
	
	@Test
	public void testCreate() {
		Extra extra = null;
		extra = new Extra(1L, "Testing", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		eR.save(extra);
	}

	@Test
	public void testUpdate() {
		Extra extra = null;
		Extra extraNew = null;
		Optional<Extra> oExtra = null;

		extra = new Extra(1L, "Testing", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		extraNew = new Extra(1L, "Testing2", new BigDecimal("3").setScale(2, BigDecimal.ROUND_UP));

		eR.save(extra);
		eR.save(extraNew);
		
		oExtra = eR.findById(extraNew.getId());

		if (oExtra.isPresent()) extra = oExtra.get();
		Assert.assertEquals(extraNew, extra);
	}

	@Test
	public void testDelete() {
		Extra extra = null;
		Optional<Extra> oExtra = null;

		extra = new Extra(1L, "Testing", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		eR.save(extra);
		eR.deleteById(extra.getId());

		oExtra = eR.findById(extra.getId());
		Assert.assertTrue(!oExtra.isPresent());
	}

}
