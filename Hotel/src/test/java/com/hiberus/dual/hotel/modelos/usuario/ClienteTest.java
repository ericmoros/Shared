package com.hiberus.dual.hotel.modelos.usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.EstadoEnum;
import com.hiberus.dual.hotel.modelos.usuario.Cliente;
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
public class ClienteTest {
	@Autowired
	private UsuarioRepositorio uR;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testRead() {
		Cliente cliente = null;
		Cliente clientesOld = null;
		Optional<Usuario> oCliente = null;
		
		cliente = new Cliente(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		clientesOld = new Cliente(cliente);
		uR.save(cliente);
		
		oCliente = uR.findById(cliente.getId());
		
		if (oCliente.isPresent()) cliente = (Cliente) oCliente.get();
		Assert.assertEquals(clientesOld, cliente);
	}
	
	@Test
	public void testReadAll() { // El test individual no funciona.
		List<Usuario> clientes = null;
		List<Usuario> clientesOld = null;

		clientes = new ArrayList<Usuario>(
			Arrays.asList(
				new Cliente[] {
					new Cliente(8L, EstadoEnum.DESHABILITADO, "DNI-Test", "Marcos"),
					new Cliente(9L, EstadoEnum.DESHABILITADO, "DNI-Test2", "Agustin"),
					new Cliente(10L, EstadoEnum.DESHABILITADO, "DNI-Test3", "Pepe"),
					new Cliente(11L, EstadoEnum.DESHABILITADO, "DNI-Test4", "Diego"),
					new Cliente(12L, EstadoEnum.DESHABILITADO, "DNI-Test5", "Martin")
				}
			)
		);
		clientesOld = new ArrayList<Usuario>(clientes);
		uR.saveAll(clientes);

		clientes = (List<Usuario>) uR.findAll();
		Assert.assertEquals(clientesOld, clientes);
		
	}

	@Test
	public void testCreate() {
		Cliente clientes = null;
		Cliente clientesOld = null;
		Optional<Usuario> oCliente = null;
		clientes = new Cliente(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(clientes);
		clientesOld = new Cliente(clientes);

		oCliente = uR.findById(clientes.getId());

		if (oCliente.isPresent()) clientes = (Cliente) oCliente.get();
		Assert.assertEquals(clientesOld, clientes);
	}

	@Test
	public void testUpdate() {
		Cliente clientes = null;
		Cliente clientesOld = null;
		Optional<Usuario> oCliente = null;

		clientes = new Cliente(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(clientes);
        
        clientes.setEstado(EstadoEnum.DESHABILITADO);
        clientes.setDni("DNI-Test 2");
        clientes.setNombre("Testing2");
		uR.save(clientes);
		clientesOld = new Cliente(clientes);
		
		oCliente = uR.findById(clientes.getId());

		if (oCliente.isPresent()) clientes = (Cliente) oCliente.get();
		Assert.assertEquals(clientesOld, clientes);
	}

	@Test
	public void testDelete() {
		Cliente clientes = null;
		Optional<Usuario> oCliente = null;

		clientes = new Cliente(1L, EstadoEnum.HABILITADO, "DNI-Test", "Agustin");
		uR.save(clientes);
        
        clientes.setEstado(EstadoEnum.BORRADO);
		uR.save(clientes);
		
		oCliente = uR.findById(clientes.getId());

		if (oCliente.isPresent()) clientes = (Cliente) oCliente.get();
		Assert.assertEquals(EstadoEnum.BORRADO, clientes.getEstado());
	}
	
}