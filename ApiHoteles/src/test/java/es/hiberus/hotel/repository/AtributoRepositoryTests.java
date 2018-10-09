package es.hiberus.hotel.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.hiberus.hotel.domain.Atributo;
import es.hiberus.hotel.repository.AtributoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtributoRepositoryTests implements IRepositoryTests {
	// Atts
	@Autowired
	private AtributoRepository atributoRepository;
	
	// Methods [private]
	private static Atributo crearAtributo() {
		Atributo atributo = new Atributo();
		atributo.setNombre("atributo1");
		return atributo;
	}
	
	// Methods [public]
	@Test
	public void contextLoads() {
	}
	
	@Test
	@Override
	public void testCreate() {
		Atributo atributo = crearAtributo();
		atributo = atributoRepository.save(atributo);
		Assert.assertNotNull(atributoRepository.findById(atributo.getId()));
	}
	
	@Test
	@Override
	public void testRead() {
		Atributo atributo = crearAtributo();
		Atributo atributoRead = atributoRepository.save(atributo);
		Assert.assertNotNull(atributoRead.getId());
	}
	
	@Test
	@Override
	public void testUpdate() {
		Atributo atributo = crearAtributo();
		Atributo atributo2 = atributoRepository.save(atributo);
		Assert.assertNotNull(atributo2);
		atributo2.setNombre("atributo2");
		atributo2 = atributoRepository.save(atributo2);	
		Assert.assertEquals("atributo2", atributoRepository.findById(atributo2.getId()).getNombre());
	}
	
	@Test
	@Override
	public void testDelete() {
		Atributo atributo = crearAtributo();
		atributo = atributoRepository.save(atributo);
		
		Assert.assertNotNull(atributo.getId());
		Assert.assertEquals(false, atributo.getBorrado());
		
		atributo.setBorrado(true);
		atributo = atributoRepository.save(atributo);
		Assert.assertTrue(atributo.getBorrado());
	}

	@Test
	@Override
	public void testReadAll() {
		
		atributoRepository.deleteAll();
		
		List<Atributo> listAtributos = new ArrayList<>();
		
		for(int i = 0; i<3;i++) {
			Atributo atributo = new Atributo();
			atributo.setNombre("atributo " + i);
			atributoRepository.save(atributo);
			listAtributos.add(atributo);
		}
		
		List<Atributo> atributos = atributoRepository.findAll();
		if (atributos.size() < 1) Assert.assertTrue(false);	
		else Assert.assertTrue(atributos.containsAll(listAtributos));
	}
	
}
