package com.hiberus.dual.hotel.controladores;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.hiberus.dual.hotel.modelos.usuario.Usuario;
import com.hiberus.dual.hotel.servicios.UsuarioServicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UsuarioControlador
 */
@Controller
@RequestMapping({ "/usuarios", "/usuario" })
public class UsuarioControlador {
    // Atts
    private Gson format;
    private UsuarioServicio uS;

    // Ctor
    public UsuarioControlador(UsuarioServicio uS) {
        this.uS = uS;
        format = new Gson();
    }

    // Methods
    @GetMapping({ "/all", "" })
    @ResponseBody
    public String getAll() {
        ArrayList<Usuario> usuarios = uS.getAll();
        String json = format.toJson(usuarios);
        return json;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String get(@PathVariable Long id) {
        Usuario usuario = uS.get(id);
        String json = format.toJson(usuario);
        return json;
    }

    @PostMapping("/add")
    public void add(@ModelAttribute("Usuario") Usuario usuario) {
        uS.add(usuario);
    }

    @PostMapping("/update")
    public void update(@ModelAttribute("Usuario") Usuario usuario) {
        uS.update(usuario);
    }

    @GetMapping("/delete/{id}")
    public void remove(@PathVariable Long id) {
        uS.remove(id);
    }

}
