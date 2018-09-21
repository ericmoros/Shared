package com.hiberus.dual.hotel.repositorios;

import com.hiberus.dual.hotel.modelos.usuario.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UsuarioRepositorio
 */
@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
}
