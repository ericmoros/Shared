package es.hiberus.hotel.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import es.hiberus.hotel.domain.EstadoHabitacion;
import es.hiberus.hotel.domain.Habitacion;

@org.springframework.stereotype.Repository
public interface HabitacionRepository extends Repository<Habitacion, Long> {

	List<Habitacion> findByBorrado(Boolean borrado);

	List<Habitacion> findAll();

	Habitacion findById(Long id);

	void deleteById(Long id);

	Habitacion save(Habitacion habitacion);
	
	Iterable<Habitacion> saveAll(Iterable<Habitacion> habitaciones);

	Habitacion findByMetros(int metros);

	void deleteAll();

	List<Habitacion> findByEstado(EstadoHabitacion estadoHabitacion);
}
