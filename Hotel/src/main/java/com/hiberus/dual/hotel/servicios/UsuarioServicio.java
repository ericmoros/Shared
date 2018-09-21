package com.hiberus.dual.hotel.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.hiberus.dual.hotel.modelos.usuario.Usuario;
import com.hiberus.dual.hotel.repositorios.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsuarioServicio
 */
@Service
public class UsuarioServicio implements IUsuarioServicio {
    private UsuarioRepositorio uR;

    @Autowired
    public UsuarioServicio(UsuarioRepositorio uR) {
        this.uR = uR;
    }

    @Override
    public ArrayList<Usuario> getAll() {
        return new ArrayList<Usuario>((Collection<? extends Usuario>) uR.findAll());
    }

    @Override
    public Usuario get(Long id) {
        Usuario usuario = null;
        Optional<Usuario> oU = uR.findById(id);
        if (oU.isPresent()) usuario = oU.get();
        return usuario;
    }

    @Override
    public void add(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        add(usuario);// Por si cambia el método.
    }
 
    @Override
    public void remove(Long id) {
        uR.deleteById(id);
    }

}
