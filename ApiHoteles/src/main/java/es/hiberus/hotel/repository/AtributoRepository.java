package es.hiberus.hotel.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import es.hiberus.hotel.domain.Atributo;
@org.springframework.stereotype.Repository
public interface AtributoRepository extends Repository<Atributo, Long> {

	List<Atributo> findByBorrado(Boolean borrado);

	List<Atributo> findAll();

	Atributo findById(Long id);

	void deleteById(Long id);

	Atributo save(Atributo atributo);

	Atributo findByNombre(String name);

	void deleteAll();

	Iterable<Atributo> saveAll(Iterable<Atributo> atributos);
}
