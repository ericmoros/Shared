package es.hiberus.hotel.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import es.hiberus.hotel.domain.Cliente;


@org.springframework.stereotype.Repository
public interface ClienteRepository extends Repository<Cliente, Long> {

	List<Cliente> findByBorrado(Boolean borrado);

	List<Cliente> findAll();

	Cliente findById(Long id);

	Cliente save(Cliente cliente);

	Cliente findByNombre(String name);
	
	void deleteById(Long id);

	void deleteAll();

}
