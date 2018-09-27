package com.hiberus.dual.hotel.modelos.habitacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	public void testReadAll() { // El test individual no funciona.
		List<Extra> extras = null;
		List<Extra> extrasOld = null;

		extras = new ArrayList<Extra>(
			Arrays.asList(
				new Extra[] {
					new Extra(4L, "Testing", new BigDecimal("2.5").setScale(2, BigDecimal.ROUND_UP)),
					new Extra(5L, "Testing2", new BigDecimal("2.9").setScale(2, BigDecimal.ROUND_UP)),
					new Extra(6L, "Testing3", new BigDecimal("2.2").setScale(2, BigDecimal.ROUND_UP)),
					new Extra(7L, "Testing4", new BigDecimal("2.0").setScale(2, BigDecimal.ROUND_UP)),
					new Extra(8L, "Testing5", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP)),
				}
			)
		);
		extrasOld = new ArrayList<Extra>(extras);
		eR.saveAll(extras);

		extras = (List<Extra>) eR.findAll();
		Assert.assertEquals(extrasOld, extras);
		
	}

	@Test
	public void testCreate() {
		Extra extra = null;
		Extra extraOld = null;
		Optional<Extra> oExtra = null;
		extra = new Extra(1L, "Testing", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		eR.save(extra);
		extraOld = new Extra(extra);

		oExtra = eR.findById(extra.getId());

		if (oExtra.isPresent()) extra = oExtra.get();
		Assert.assertEquals(extraOld, extra);
	}

	@Test
	public void testUpdate() {
		Extra extra = null;
		Extra extraOld = null;
		Optional<Extra> oExtra = null;

		extra = new Extra(1L, "Testing", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		eR.save(extra);
		
		extra.setNombre("Testing2");
		extra.setPrecio(new BigDecimal("3").setScale(2, BigDecimal.ROUND_UP));
		eR.save(extra);
		extraOld = new Extra(extra);
		
		oExtra = eR.findById(extra.getId());

		if (oExtra.isPresent()) extra = oExtra.get();
		Assert.assertEquals(extraOld, extra);
	}

	@Test
	public void testDelete() {
		Extra extra = null;
		Optional<Extra> oExtra = null;

		extra = new Extra(1L, "Testing", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		extra = eR.save(extra);
		eR.deleteById(extra.getId());

		oExtra = eR.findById(extra.getId());
		Assert.assertTrue(!oExtra.isPresent());
	}


}
