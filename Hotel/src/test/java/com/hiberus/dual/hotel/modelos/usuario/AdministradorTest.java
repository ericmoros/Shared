package com.hiberus.dual.hotel.modelos.usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
import com.hiberus.dual.hotel.modelos.usuario.Administrador;
import com.hiberus.dual.hotel.modelos.usuario.Usuario;
import com.hiberus.dual.hotel.repositorios.UsuarioRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministradorTest {
	@Autowired
	private UsuarioRepositorio uR;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testRead() {
		Administrador administrador = null;
		Administrador administradorsOld = null;
		Optional<Usuario> oadministrador = null;
		
		administrador = new Administrador(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		administradorsOld = new Administrador(administrador);
		uR.save(administrador);
		
		oadministrador = uR.findById(administrador.getId());
		
		if (oadministrador.isPresent()) administrador = (Administrador) oadministrador.get();
		Assert.assertEquals(administradorsOld, administrador);
	}
	
	@Test
	public void testReadAll() { // El test individual no funciona.
		List<Usuario> administradors = null;
		List<Usuario> administradorsOld = null;

		administradors = new ArrayList<Usuario>(
			Arrays.asList(
				new Administrador[] {
					new Administrador(8L, EstadoEnum.DESHABILITADO, "DNI-Test", "Marcos"),
					new Administrador(9L, EstadoEnum.DESHABILITADO, "DNI-Test2", "Agustin"),
					new Administrador(10L, EstadoEnum.DESHABILITADO, "DNI-Test3", "Pepe"),
					new Administrador(11L, EstadoEnum.DESHABILITADO, "DNI-Test4", "Diego"),
					new Administrador(12L, EstadoEnum.DESHABILITADO, "DNI-Test5", "Martin")
				}
			)
		);
		administradorsOld = new ArrayList<Usuario>(administradors);
		uR.saveAll(administradors);

		administradors = (List<Usuario>) uR.findAll();
		Assert.assertEquals(administradorsOld, administradors);
		
	}

	@Test
	public void testCreate() {
		Administrador administradors = null;
		Administrador administradorsOld = null;
		Optional<Usuario> oadministrador = null;
		administradors = new Administrador(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(administradors);
		administradorsOld = new Administrador(administradors);

		oadministrador = uR.findById(administradors.getId());

		if (oadministrador.isPresent()) administradors = (Administrador) oadministrador.get();
		Assert.assertEquals(administradorsOld, administradors);
	}

	@Test
	public void testUpdate() {
		Administrador administradors = null;
		Administrador administradorsOld = null;
		Optional<Usuario> oadministrador = null;

		administradors = new Administrador(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(administradors);
        
        administradors.setEstado(EstadoEnum.HABILITADO);
        administradors.setDni("DNI-Test 2");
        administradors.setNombre("Testing2");
		uR.save(administradors);
		administradorsOld = new Administrador(administradors);
		
		oadministrador = uR.findById(administradors.getId());

		if (oadministrador.isPresent()) administradors = (Administrador) oadministrador.get();
		Assert.assertEquals(administradorsOld, administradors);
	}

	@Test
	public void testDelete() {
		Administrador administradors = null;
		Optional<Usuario> oadministrador = null;

		administradors = new Administrador(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(administradors);
        
        administradors.setEstado(EstadoEnum.BORRADO);
		uR.save(administradors);
		
		oadministrador = uR.findById(administradors.getId());

		if (oadministrador.isPresent()) administradors = (Administrador) oadministrador.get();
		Assert.assertEquals(EstadoEnum.BORRADO, administradors.getEstado());
	}
	
}