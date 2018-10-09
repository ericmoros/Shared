package es.hiberus.hotel.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import es.hiberus.hotel.domain.Gerente;
@org.springframework.stereotype.Repository
public interface GerenteRepository extends Repository<Gerente, Long> {

	List<Gerente> findByBorrado(Boolean borrado);

	List<Gerente> findAll();

	Gerente findById(Long id);

	void deleteById(Long id);
	
	Gerente save(Gerente gerente);

	Gerente findByNombre(String name);

	void deleteAll();

	Iterable<Gerente> saveAll(Iterable<Gerente> gerentes);

}
