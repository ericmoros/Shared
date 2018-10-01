package com.hiberus.dual.hotel.modelos.hotel;

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

	@Test
	public void testRead() {
		Reserva reserva = null;
		Reserva reservaOld = null;
		Optional<Reserva> oReserva= null;
		reserva = new Reserva(1L, EstadoEnum.DESHABILITADO, LocalDate.now(), LocalDate.now(), null, null, null);
		rR.save(reserva);
		reservaOld = new Reserva(reserva);

		oReserva = rR.findById(reserva.getId());

		if (oReserva.isPresent()) reserva = oReserva.get();
		Assert.assertEquals(reservaOld, reserva);
	}
	
	@Test
	public void testCreate() {
		Reserva reserva = null;
		Reserva reservaOld = null;
		Optional<Reserva> oReserva= null;
		reserva = new Reserva(1L, EstadoEnum.DESHABILITADO, LocalDate.now(), LocalDate.now(), null, null, null);
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

		reserva = new Reserva(1L, EstadoEnum.DESHABILITADO, LocalDate.now(), LocalDate.now(), null, null, null);
		rR.save(reserva);
		
		reserva.setEstado(EstadoEnum.HABILITADO);
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

		reserva = new Reserva(1L, EstadoEnum.DESHABILITADO, LocalDate.now(), LocalDate.now(), null, null, null);
		rR.save(reserva);
		
		reserva.setEstado(EstadoEnum.BORRADO);
		rR.save(reserva);
		
		oReserva = rR.findById(reserva.getId());

		if (oReserva.isPresent()) reserva = oReserva.get();
		Assert.assertEquals(EstadoEnum.BORRADO, reserva.getEstado());
	}
	
	
}
