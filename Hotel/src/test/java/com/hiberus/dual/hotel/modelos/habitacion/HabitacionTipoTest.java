package com.hiberus.dual.hotel.modelos.habitacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
import com.hiberus.dual.hotel.repositorios.HabitacionTipoRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HabitacionTipoTest {
	@Autowired
	private HabitacionTipoRepositorio hTR;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testRead() {
		HabitacionTipo habitacionTipo = null;
		HabitacionTipo habitacionTipoOld = null;
		Optional<HabitacionTipo> ohabitacionTipo = null;

		habitacionTipo = new HabitacionTipo(1L, EstadoEnum.DESHABILITADO, "GUAY", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		habitacionTipoOld = new HabitacionTipo(habitacionTipo);
		hTR.save(habitacionTipo);
		
		ohabitacionTipo = hTR.findById(habitacionTipo.getId());

		if (ohabitacionTipo.isPresent()) habitacionTipo = ohabitacionTipo.get();
		Assert.assertEquals(habitacionTipoOld, habitacionTipo);
	}

	@Test
	public void testReadAll() { // El test individual no funciona.
		hTR.deleteAll();
		List<HabitacionTipo> hTipos = null;
		List<HabitacionTipo> hTiposOld = null;

		hTipos = new ArrayList<HabitacionTipo>(
			Arrays.asList(
				new HabitacionTipo[] {
					new HabitacionTipo().estado(EstadoEnum.DESHABILITADO).nombre("Testing1").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP)),
					new HabitacionTipo().estado(EstadoEnum.DESHABILITADO).nombre("Testing2").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP)),
					new HabitacionTipo().estado(EstadoEnum.DESHABILITADO).nombre("Testing3").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP)),
					new HabitacionTipo().estado(EstadoEnum.DESHABILITADO).nombre("Testing4").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP)),
					new HabitacionTipo().estado(EstadoEnum.DESHABILITADO).nombre("Testing5").precio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP))
				}
			)
		);
		hTiposOld = (List<HabitacionTipo>) hTR.saveAll(hTipos);

		hTipos = (List<HabitacionTipo>) hTR.findAll();
		Assert.assertEquals(hTiposOld, hTipos);
		
	}
	
	@Test
	public void testCreate() {
		HabitacionTipo habitacionTipo = null;
		HabitacionTipo habitacionTipoOld = null;
		Optional<HabitacionTipo> ohabitacionTipo= null;
		habitacionTipo = new HabitacionTipo(1L, EstadoEnum.DESHABILITADO, "GUAY", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		hTR.save(habitacionTipo);
		habitacionTipoOld = new HabitacionTipo(habitacionTipo);

		ohabitacionTipo = hTR.findById(habitacionTipo.getId());

		if (ohabitacionTipo.isPresent()) habitacionTipo = ohabitacionTipo.get();
		Assert.assertEquals(habitacionTipoOld, habitacionTipo);
	}

	@Test
	public void testUpdate() {
		HabitacionTipo habitacionTipo = null;
		HabitacionTipo habitacionTipoOld = null;
		Optional<HabitacionTipo> ohabitacionTipo = null;

		habitacionTipo = new HabitacionTipo(1L, EstadoEnum.DESHABILITADO, "GUAY", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		hTR.save(habitacionTipo);
		
        habitacionTipo.setNombre("habitacionTipo Pepino");
        
		hTR.save(habitacionTipo);
		habitacionTipoOld = new HabitacionTipo(habitacionTipo);

		
		ohabitacionTipo = hTR.findById(habitacionTipo.getId());

		if (ohabitacionTipo.isPresent()) habitacionTipo = ohabitacionTipo.get();
		Assert.assertEquals(habitacionTipoOld, habitacionTipo);
	}

	@Test
	public void testDelete() {
		HabitacionTipo habitacionTipo = null;
		Optional<HabitacionTipo> oHabitacionTipo = null;

		habitacionTipo = new HabitacionTipo(1L, EstadoEnum.DESHABILITADO, "GUAY", new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		hTR.save(habitacionTipo);
		
        habitacionTipo.setEstado(EstadoEnum.BORRADO);
		hTR.save(habitacionTipo);
		
		oHabitacionTipo = hTR.findById(habitacionTipo.getId());

		if (oHabitacionTipo.isPresent()) habitacionTipo = oHabitacionTipo.get();
		Assert.assertEquals(EstadoEnum.BORRADO, habitacionTipo.getEstado());
	}
	
	
}
