package com.hiberus.dual.hotel.modelos.habitacion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
import com.hiberus.dual.hotel.modelos.hotel.Reserva;
import com.hiberus.dual.hotel.repositorios.ReservaRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservaTest {
	@Autowired
	private ReservaRepositorio rR;

	@Test
	public void contextLoads() {
	}

	public void testRead() {
		Reserva reserva = null;
		Reserva reservaOld = null;
		Optional<Reserva> oReserva = null;

		reserva = new Reserva(1L, null, EstadoEnum.DESHABILITADO, LocalDate.now(), LocalDate.now(), null, null, new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		reservaOld = new Reserva(reserva);
		rR.save(reserva);
		
		oReserva = rR.findById(reserva.getId());

		if (oReserva.isPresent()) reserva = oReserva.get();
		Assert.assertEquals(reservaOld, reserva);
	}
	
	@Test
	public void testCreate() {
		Reserva reserva = null;
		Reserva reservaOld = null;
		Optional<Reserva> oReserva= null;
		reserva = new Reserva(1L, null, EstadoEnum.DESHABILITADO, LocalDate.now(), LocalDate.now(), null, null, new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		rR.save(reserva);
		reservaOld = new Reserva(reserva);

		oReserva = rR.findById(reserva.getId());

		if (oReserva.isPresent()) reserva = oReserva.get();
		Assert.assertEquals(reservaOld, reserva);
	}

	@Test
	public void testUpdate() {
		Reserva reserva = null;
		Reserva reservaOld = null;
		Optional<Reserva> oReserva = null;

		reserva = new Reserva(1L, null, EstadoEnum.DESHABILITADO, LocalDate.now(), LocalDate.now(), null, null, new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		rR.save(reserva);
		
		reserva.setEstado(EstadoEnum.BORRADO);
		reserva.setFechai(LocalDate.now());
		reserva.setFechaf(LocalDate.now());
		rR.save(reserva);
		reservaOld = new Reserva(reserva);

		
		oReserva = rR.findById(reserva.getId());

		if (oReserva.isPresent()) reserva = oReserva.get();
		Assert.assertEquals(reservaOld, reserva);
	}

	@Test
	public void testDelete() {
		Reserva reserva = null;
		Optional<Reserva> oReserva = null;

		reserva = new Reserva(1L, null, EstadoEnum.DESHABILITADO, LocalDate.now(), LocalDate.now(), null, null, new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
		reserva = rR.save(reserva);
		rR.deleteById(reserva.getId());

		oReserva = rR.findById(reserva.getId());
		Assert.assertTrue(!oReserva.isPresent());
	}
	
	
}
