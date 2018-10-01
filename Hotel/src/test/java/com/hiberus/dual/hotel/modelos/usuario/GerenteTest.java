package com.hiberus.dual.hotel.modelos.usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
import com.hiberus.dual.hotel.repositorios.UsuarioRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GerenteTest {
	@Autowired
	private UsuarioRepositorio uR;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testRead() {
		Gerente gerente = null;
		Gerente gerentesOld = null;
		Optional<Usuario> ogerente = null;
		
		gerente = new Gerente(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		gerentesOld = new Gerente(gerente);
		uR.save(gerente);
		
		ogerente = uR.findById(gerente.getId());
		
		if (ogerente.isPresent()) gerente = (Gerente) ogerente.get();
		Assert.assertEquals(gerentesOld, gerente);
	}
	
	@Test
	public void testReadAll() { // El test individual no funciona.
		List<Usuario> gerentes = null;
		List<Usuario> gerentesOld = null;

		gerentes = new ArrayList<Usuario>(
			Arrays.asList(
				new Gerente[] {
					new Gerente(8L, EstadoEnum.DESHABILITADO, "DNI-Test", "Marcos"),
					new Gerente(9L, EstadoEnum.DESHABILITADO, "DNI-Test2", "Agustin"),
					new Gerente(10L, EstadoEnum.DESHABILITADO, "DNI-Test3", "Pepe"),
					new Gerente(11L, EstadoEnum.DESHABILITADO, "DNI-Test4", "Diego"),
					new Gerente(12L, EstadoEnum.DESHABILITADO, "DNI-Test5", "Martin")
				}
			)
		);
		gerentesOld = new ArrayList<Usuario>(gerentes);
		uR.saveAll(gerentes);

		gerentes = (List<Usuario>) uR.findAll();
		Assert.assertEquals(gerentesOld, gerentes);
		
	}

	@Test
	public void testCreate() {
		Gerente gerentes = null;
		Gerente gerentesOld = null;
		Optional<Usuario> ogerente = null;
		gerentes = new Gerente(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(gerentes);
		gerentesOld = new Gerente(gerentes);

		ogerente = uR.findById(gerentes.getId());

		if (ogerente.isPresent()) gerentes = (Gerente) ogerente.get();
		Assert.assertEquals(gerentesOld, gerentes);
	}

	@Test
	public void testUpdate() {
		Gerente gerentes = null;
		Gerente gerentesOld = null;
		Optional<Usuario> ogerente = null;

		gerentes = new Gerente(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(gerentes);
        
        gerentes.setEstado(EstadoEnum.DESHABILITADO);
        gerentes.setDni("DNI-Test 2");
        gerentes.setNombre("Testing2");
		uR.save(gerentes);
		gerentesOld = new Gerente(gerentes);
		
		ogerente = uR.findById(gerentes.getId());

		if (ogerente.isPresent()) gerentes = (Gerente) ogerente.get();
		Assert.assertEquals(gerentesOld, gerentes);
	}

	@Test
	public void testDelete() {
		Gerente gerentes = null;
		Optional<Usuario> ogerente = null;

		gerentes = new Gerente(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(gerentes);
        
        gerentes.setEstado(EstadoEnum.BORRADO);
		uR.save(gerentes);
		
		ogerente = uR.findById(gerentes.getId());

		if (ogerente.isPresent()) gerentes = (Gerente) ogerente.get();
		Assert.assertEquals(EstadoEnum.BORRADO, gerentes.getEstado());
	}
	
}