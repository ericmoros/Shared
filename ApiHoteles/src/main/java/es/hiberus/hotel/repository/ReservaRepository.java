package es.hiberus.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import es.hiberus.hotel.domain.Cliente;
import es.hiberus.hotel.domain.Hotel;
import es.hiberus.hotel.domain.Reserva;

@org.springframework.stereotype.Repository
public interface ReservaRepository extends Repository<Reserva, Long> {

	List<Reserva> findByBorrado(Boolean borrado);

	List<Reserva> findAll();

	Reserva findById(Long id);

	void deleteById(Long id);

	Reserva save(Reserva reserva);
	
	Iterable<Reserva> saveAll(Iterable<Reserva> reservas);

	void deleteAll();

	List<Reserva> findByCliente(Cliente cliente);
	
	@Query(value =
		"SELECT HOTEL.*\r\n" + 
		"	FROM RESERVA\r\n" + 
		"	JOIN RESERVA_HABITACIONES ON (RESERVA.ID = RESERVA_HABITACIONES. RESERVA_ID)\r\n" + 
		"	JOIN HOTEL_HABITACIONES ON (RESERVA_HABITACIONES.HABITACIONES_ID = HOTEL_HABITACIONES.HABITACIONES_ID)\r\n" + 
		"	JOIN HOTEL ON (HOTEL_HABITACIONES.HOTEL_ID = HOTEL.ID)" +
		"	WHERE RESERVA.ID = ?1;", nativeQuery = true)
	Hotel findHotel();
}
