package es.hiberus.hotel.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTests implements IRepositoryTests {
	// Atts
	@Autowired
	private ClienteRepository clienteRepository;
	
	// Methods [private]
	private static Cliente crearCliente() {
		Cliente cliente = new Cliente();
		cliente.setNombre("cliente1");
		return cliente;
	}
	
	// Methods [public]
	@Test
	public void contextLoads() {
	}
	
	@Test
	@Override
	public void testCreate() {
		Cliente cliente = crearCliente();
		cliente = clienteRepository.save(cliente);
		Assert.assertNotNull(clienteRepository.findById(cliente.getId()));
	}

	@Test
	@Override
	public void testRead() {
		Cliente cliente = crearCliente();
		Cliente clienteRead = clienteRepository.save(cliente);
		Assert.assertNotNull(clienteRead.getId());
	}

	@Test
	@Override
	public void testUpdate() {
		Cliente cliente = crearCliente();
		Cliente cliente2 = clienteRepository.save(cliente);
		Assert.assertNotNull(cliente2.getId());
		cliente2.setNombre("cliente2");
		cliente2 = clienteRepository.save(cliente2);
		Assert.assertEquals("cliente2", clienteRepository.findById(cliente2.getId()).getNombre());
	}

	@Test
	@Override
	public void testDelete() {
		Cliente cliente = crearCliente();
		cliente = clienteRepository.save(cliente);

		Assert.assertNotNull(cliente.getId());
		Assert.assertEquals(false, cliente.getBorrado());

		cliente.setBorrado(true);
		cliente = clienteRepository.save(cliente);
		Assert.assertTrue(cliente.getBorrado());
	}

	@Test
	@Override
	public void testReadAll() {
		clienteRepository.deleteAll();

		List<Cliente> listClientes = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("cliente " + i);
			clienteRepository.save(cliente);
			listClientes.add(cliente);
		}

		List<Cliente> clientes = clienteRepository.findAll();
		if (clientes.size() < 1) Assert.assertTrue(false);	
		else Assert.assertTrue(clientes.containsAll(listClientes));
	}

	
}
