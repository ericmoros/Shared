package es.hiberus.hotel.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.domain.Reserva;

@org.springframework.stereotype.Repository
public interface HotelRepository extends Repository<Hotel, Long> {

	List<Hotel> findByBorrado(Boolean borrado);

	List<Hotel> findAll();

	Hotel findById(Long id);

	void deleteById(Long id);

	Hotel save(Hotel hotel);
	
	Iterable<Hotel> saveAll(Iterable<Hotel> hoteles);

	Hotel findByNombre(String name);

	void deleteAll();

	
}
