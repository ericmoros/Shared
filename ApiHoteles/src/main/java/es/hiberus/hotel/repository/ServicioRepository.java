package es.hiberus.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import es.hiberus.hotel.domain.Servicio;

@org.springframework.stereotype.Repository
public interface ServicioRepository extends Repository<Servicio, Long> {

	List<Servicio> findByBorrado(Boolean borrado);

	List<Servicio> findAll();

	Servicio findById(Long id);

	void deleteById(Long id);

	Servicio save(Servicio servicio);

	Servicio findByNombre(String name);

	void deleteAll();

	Iterable<Servicio> saveAll(Iterable<Servicio> servicio);

	@Query(value = "SELECT SERVICIO.* FROM SERVICIO JOIN HOTEL_SERVICIOS on (servicio.id = hotel_servicios.servicios_id) JOIN HOTEL on (hotel_servicios.hotel_id = hotel.id) WHERE hotel.id = ?1", nativeQuery = true)
	List<Servicio> findByHotelId(Long hotelId);

}
