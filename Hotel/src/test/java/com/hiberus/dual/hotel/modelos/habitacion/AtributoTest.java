package com.hiberus.dual.hotel.modelos.habitacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
import com.hiberus.dual.hotel.repositorios.AtributoRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtributoTest {
	@Autowired
	private AtributoRepositorio aR;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testRead() {
		Atributo atributo = null;
		Atributo atributoOld = null;
		Optional<Atributo> oAtributo = null;
		
		atributo = new Atributo().estado(EstadoEnum.DESHABILITADO).nombre("Testing").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		atributoOld = aR.save(atributo);
		
		oAtributo = aR.findById(atributo.getId());
		
		if (oAtributo.isPresent()) atributo = oAtributo.get();
		Assert.assertEquals(atributoOld, atributo);
	}
	
	@Test
	public void testReadAll() { // El test individual no funciona.
		aR.deleteAll();
		List<Atributo> atributos = null;
		List<Atributo> atributosOld = null;

		atributos = new ArrayList<Atributo>(
			Arrays.asList(
				new Atributo[] {
					new Atributo().estado(EstadoEnum.DESHABILITADO).nombre("Testing1").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP)),
					new Atributo().estado(EstadoEnum.DESHABILITADO).nombre("Testing2").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP)),
					new Atributo().estado(EstadoEnum.DESHABILITADO).nombre("Testing3").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP)),
					new Atributo().estado(EstadoEnum.DESHABILITADO).nombre("Testing4").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP)),
					new Atributo().estado(EstadoEnum.DESHABILITADO).nombre("Testing5").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP))
				}
			)
		);
		atributosOld = (List<Atributo>) aR.saveAll(atributos);

		atributos = (List<Atributo>) aR.findAll();
		Assert.assertEquals(atributosOld, atributos);
		
	}

	@Test
	public void testCreate() {
		Atributo atributo = null;
		Atributo atributoOld = null;
		Optional<Atributo> oAtributo = null;
		atributo = new Atributo().estado(EstadoEnum.DESHABILITADO).nombre("Testing1").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		atributoOld = aR.save(atributo);

		oAtributo = aR.findById(atributo.getId());

		if (oAtributo.isPresent()) atributo = oAtributo.get();
		Assert.assertEquals(atributoOld, atributo);
	}

	@Test
	public void testUpdate() {
		Atributo atributo = null;
		Atributo atributoOld = null;
		Optional<Atributo> oAtributo = null;

		atributo = new Atributo().estado(EstadoEnum.DESHABILITADO).nombre("Testing1").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		atributo = aR.save(atributo);
		
		atributo.setNombre("Testing2");
		atributo.setPrecio(new BigDecimal("3").setScale(2, BigDecimal.ROUND_UP));
		atributoOld = aR.save(atributo);
		
		oAtributo = aR.findById(atributo.getId());

		if (oAtributo.isPresent()) atributo = oAtributo.get();
		Assert.assertEquals(atributoOld, atributo);
	}

	@Test
	public void testDelete() {
		Atributo atributo = null;
		Optional<Atributo> oAtributo = null;

		atributo = new Atributo().estado(EstadoEnum.DESHABILITADO).nombre("Testing1").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		atributo = aR.save(atributo);
		
		atributo.setEstado(EstadoEnum.BORRADO);
		atributo = aR.save(atributo);
		
		oAtributo = aR.findById(atributo.getId());

		if (oAtributo.isPresent()) atributo = oAtributo.get();
		Assert.assertEquals(EstadoEnum.BORRADO, atributo.getEstado());
	}
	
}
