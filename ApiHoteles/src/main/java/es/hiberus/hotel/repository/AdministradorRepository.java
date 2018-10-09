package es.hiberus.hotel.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import es.hiberus.hotel.domain.Administrador;

@org.springframework.stereotype.Repository
public interface AdministradorRepository extends Repository<Administrador, Long> {

	List<Administrador> findByBorrado(Boolean borrado);

	List<Administrador> findAll();

	void deleteById(Long id);
	
	Administrador findById(Long id);

	Administrador save(Administrador admin);

	Administrador findByNombre(String name);

	void deleteAll();

}
