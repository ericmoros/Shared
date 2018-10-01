package com.hiberus.dual.hotel.servicios.interfaces;

import java.util.ArrayList;

import com.hiberus.dual.hotel.modelos.usuario.Usuario;

/**
 * IUsuarioServicio
 * @see UsuarioServicio
 */
public interface IUsuarioServicio {

    ArrayList<Usuario> getAll();

    Usuario get(Long id);

    void add(Usuario usuario);

    void update(Usuario usuario);

    void remove(Long id);

    
}
