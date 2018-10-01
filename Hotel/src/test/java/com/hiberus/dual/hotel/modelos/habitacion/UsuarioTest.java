package com.hiberus.dual.hotel.modelos.habitacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
import com.hiberus.dual.hotel.modelos.usuario.Usuario;
import com.hiberus.dual.hotel.repositorios.AtributoRepositorio;
import com.hiberus.dual.hotel.repositorios.UsuarioRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {
	@Autowired
	private UsuarioRepositorio uR;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testRead() {
		Usuario usuarios = null;
		Usuario usuariosOld = null;
		Optional<Usuario> oUsuario = null;
		
		usuarios = new Usuario(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		usuariosOld = new Usuario(usuarios);
		uR.save(usuarios);
		
		oUsuario = uR.findById(usuarios.getId());
		
		if (oUsuario.isPresent()) usuarios = oUsuario.get();
		Assert.assertEquals(usuariosOld, usuarios);
	}
	
	@Test
	public void testReadAll() { // El test individual no funciona.
		List<Usuario> usuarios = null;
		List<Usuario> usuariosOld = null;

		usuarios = new ArrayList<Usuario>(
			Arrays.asList(
				new Usuario[] {
					new Usuario(8L, EstadoEnum.HABILITADO, "DNI-Test", "Marcos"),
					new Usuario(9L, EstadoEnum.DESHABILITADO, "DNI-Test2", "Agustin"),
					new Usuario(10L, EstadoEnum.DESHABILITADO, "DNI-Test3", "Pepe"),
					new Usuario(11L, EstadoEnum.HABILITADO, "DNI-Test4", "Diego"),
					new Usuario(12L, EstadoEnum.BORRADO, "DNI-Test5", "Martin"),
				}
			)
		);
		usuariosOld = new ArrayList<Usuario>(usuarios);
		uR.saveAll(usuarios);

		usuarios = (List<Usuario>) uR.findAll();
		Assert.assertEquals(usuariosOld, usuarios);
		
	}

	@Test
	public void testCreate() {
		Usuario usuarios = null;
		Usuario usuariosOld = null;
		Optional<Usuario> oUsuario = null;
		usuarios = new Usuario(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(usuarios);
		usuariosOld = new Usuario(usuarios);

		oUsuario = uR.findById(usuarios.getId());

		if (oUsuario.isPresent()) usuarios = oUsuario.get();
		Assert.assertEquals(usuariosOld, usuarios);
	}

	@Test
	public void testUpdate() {
		Usuario usuarios = null;
		Usuario usuariosOld = null;
		Optional<Usuario> oUsuario = null;

		usuarios = new Usuario(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(usuarios);
        
        usuarios.setEstado(EstadoEnum.DESHABILITADO);
        usuarios.setDni("DNI-Test 2");
        usuarios.setNombre("Testing2");
		uR.save(usuarios);
		usuariosOld = new Usuario(usuarios);
		
		oUsuario = uR.findById(usuarios.getId());

		if (oUsuario.isPresent()) usuarios = oUsuario.get();
		Assert.assertEquals(usuariosOld, usuarios);
	}

	@Test
	public void testDelete() {
		Usuario usuarios = null;
		Optional<Usuario> oUsuario = null;

		usuarios = new Usuario(1L, EstadoEnum.DESHABILITADO, "DNI-Test", "Agustin");
		usuarios = uR.save(usuarios);
		uR.deleteById(usuarios.getId());

		oUsuario = uR.findById(usuarios.getId());
		Assert.assertTrue(!oUsuario.isPresent());
	}
	
}