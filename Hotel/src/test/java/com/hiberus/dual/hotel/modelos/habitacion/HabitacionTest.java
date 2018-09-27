package com.hiberus.dual.hotel.modelos.habitacion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HabitacionTest {
	// @Autowired
	// private HabitacionRepositorio hR;

	@Test
	public void contextLoads() {
	}

	// @Test
	// public void testCreate() {
	// 	Habitacion habitacion = new Habitacion();
	// 	Optional<Habitacion> oRHabitacion = null;
    //     Habitacion rHabitacion = null;
    //     Extra extras = new Extra(1L, "1",new BigDecimal("1").setScale(2, BigDecimal.ROUND_UP));

	// 	habitacion.setId(1L);
	// 	habitacion.setNumero("A-1");
    //     habitacion.setEs(EstadoEnum.LIBRE);
    //     habitacion.setTipo(new HabitacionTipo());
    //     habitacion.setExtras(extras.());
    //     habitacion.setHotel(new Hotel());
	// 	hR.save(habitacion);

	// 	oRHabitacion = hR.findById(habitacion.getId());
	// 	if (oRHabitacion.isPresent()) rHabitacion = oRHabitacion.get();
		
	// 	Assert.assertNotNull(habitacion.getId());
	// 	Assert.assertEquals((Long)1L, rHabitacion.getId());
	// 	Assert.assertEquals("A-1", rHabitacion.getNumero());
    //     Assert.assertEquals(EstadoEnum.LIBRE, rHabitacion.getEs());
    //     Assert.assertEquals((new HabitacionTipo().getNombre()), rHabitacion.getTipo());
    //     Assert.assertEquals(new Extra().getNombre()); // Extras
    //     Assert.assertEquals((new Hotel().getId()), rHabitacion.getHotel());
	// }

	// @Test
	// public void testUpdate() {
	// 	Habitacion habitacion = new Habitacion();
	// 	Optional<Habitacion> oRHabitacion = null;
	// 	Habitacion rHabitacion = null;

	// 	habitacion.setId(1L);
	// 	habitacion.setNombre("Testing");
	// 	habitacion.setPrecio(new BigDecimal("1").setScale(2, BigDecimal.ROUND_UP));
	// 	hR.save(habitacion);
		
	// 	habitacion.setId(2L);
	// 	habitacion.setNombre("Testing2");
	// 	habitacion.setPrecio(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP));
	// 	hR.save(habitacion);

	// 	oRHabitacion = hR.findById(habitacion.getId());
	// 	if (oRHabitacion.isPresent())
    //     rHabitacion = oRHabitacion.get();
	// 	Assert.assertNotNull(habitacion.getId());
	// 	Assert.assertEquals((Long) 2L, rHabitacion.getId());
	// 	Assert.assertEquals("Testing2", rHabitacion.getNombre());
	// 	Assert.assertEquals(new BigDecimal("2").setScale(2, BigDecimal.ROUND_UP), rHabitacion.getPrecio());
	// }

	
}
