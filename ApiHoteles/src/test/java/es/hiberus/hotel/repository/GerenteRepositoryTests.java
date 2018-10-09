package es.hiberus.hotel.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Gerente;
import es.hiberus.hotel.repository.GerenteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GerenteRepositoryTests implements IRepositoryTests {
	// Atts
	@Autowired
	private GerenteRepository gerenteRepository;
	
	// Methods [private]
	private static Gerente crearGerente() {
		Gerente gerente = new Gerente();
		gerente.setNombre("gerente1");
		return gerente;
	}
	
	// Methods [public]
	public void contextLoads() {
	}
	
	@Test
	@Override
	public void testCreate() {
		Gerente gerente = crearGerente();
		gerente = gerenteRepository.save(gerente);
		Assert.assertNotNull(gerenteRepository.findById(gerente.getId()));
	}
	
	@Test
	@Override
	public void testRead() {
		Gerente gerente = crearGerente();
		Gerente gerenteRead = gerenteRepository.save(gerente);
		Assert.assertNotNull(gerenteRead.getId());
	}
	
	@Test
	@Override
	public void testUpdate() {
		Gerente gerente = crearGerente();
		Gerente gerente2 = gerenteRepository.save(gerente);
		Assert.assertNotNull(gerente2.getId());
		gerente2.setNombre("gerente2");
		gerente2 = gerenteRepository.save(gerente2);
		Assert.assertEquals("gerente2", gerenteRepository.findById(gerente2.getId()).getNombre());
	}
	
	@Test
	@Override
	public void testDelete() {
		Gerente gerente = crearGerente();
		gerente = gerenteRepository.save(gerente);
		
		Assert.assertNotNull(gerente.getId());
		Assert.assertEquals(false, gerente.getBorrado());
		
		gerente.setBorrado(true);
		gerente = gerenteRepository.save(gerente);
		Assert.assertTrue(gerente.getBorrado());
	}

	@Test
	@Override
	public void testReadAll() {
		gerenteRepository.deleteAll();
		
		List<Gerente> listGerentes = new ArrayList<>();
		
		for(int i = 0; i<3;i++) {
			Gerente gerente = new Gerente();
			gerente.setNombre("gerente " + i);
			gerenteRepository.save(gerente);
			listGerentes.add(gerente);
		}
		
		List<Gerente> gerentes = gerenteRepository.findAll();
		if (gerentes.size() < 1) Assert.assertTrue(false);	
		else Assert.assertTrue(gerentes.containsAll(listGerentes));
	}
	
}
