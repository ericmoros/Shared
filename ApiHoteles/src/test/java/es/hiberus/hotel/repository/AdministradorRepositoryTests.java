package es.hiberus.hotel.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Administrador;
import es.hiberus.hotel.repository.AdministradorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministradorRepositoryTests implements IRepositoryTests {
	// Atts
	@Autowired
	private AdministradorRepository administradorRepository;
	
	// Methods [private]
	private static Administrador crearAdministrador() {
		Administrador administrador = new Administrador();
		administrador.setNombre("administrador1");
		return administrador;
	}
	
	// Methods [public]
	@Test
	public void contextLoads() {
	}
	
	@Test
	@Override
	public void testCreate() {
		Administrador administrador = crearAdministrador();
		administrador = administradorRepository.save(administrador);
		Assert.assertNotNull(administradorRepository.findById(administrador.getId()));
	}
	
	@Test
	@Override
	public void testRead() {
		Administrador administrador = new Administrador();
		administrador.setNombre("administrador1");
		Administrador administradorRead = administradorRepository.save(administrador);
		Assert.assertNotNull(administradorRead.getId());
	}
	
	@Test
	@Override
	public void testUpdate() {
		Administrador administrador = crearAdministrador();
		Administrador administrador2 = administradorRepository.save(administrador);
		Assert.assertNotNull(administrador2.getId());
		administrador2.setNombre("administrador2");
		administrador2 = administradorRepository.save(administrador2);
		Assert.assertEquals("administrador2", administradorRepository.findById(administrador2.getId()).getNombre());
	}
	
	@Test
	@Override
	public void testDelete() {
		Administrador admin = crearAdministrador();
		admin = administradorRepository.save(admin);
		
		Assert.assertNotNull(admin.getId());
		Assert.assertEquals(false, admin.getBorrado());
		
		admin.setBorrado(true);
		admin = administradorRepository.save(admin);
		Assert.assertEquals(admin.getBorrado(), true);
	}

	@Test
	@Override
	public void testReadAll() {
		administradorRepository.deleteAll();
		
		ArrayList<Administrador> listAdministradores = new ArrayList<>();
		
		for(int i = 0; i<3;i++) {
			Administrador administrador = new Administrador();
			administrador.setNombre("administrador " + i);
			administradorRepository.save(administrador);
			listAdministradores.add(administrador);
		}
		
		List<Administrador> administradores = administradorRepository.findAll();
		if (administradores.size() < 1) Assert.assertTrue(false);	
		else Assert.assertTrue(administradores.containsAll(listAdministradores));
	}
	
	
}
