package com.hiberus.dual.hotel.controladores;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.hiberus.dual.hotel.modelos.hotel.Servicio;
import com.hiberus.dual.hotel.servicios.ServicioServicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ServicioControlador
 */
@Controller
@RequestMapping({ "/servicios", "/servicio" })
public class ServicioControlador {
    // Atts
    private Gson format;
    private ServicioServicio uS;

    // Ctor
    public ServicioControlador(ServicioServicio uS) {
        this.uS = uS;
        format = new Gson();
    }

    // Methods
    @GetMapping({ "/all", "" })
    @ResponseBody
    public String getAll() {
        ArrayList<Servicio> servicios = uS.getAll();
        String json = format.toJson(servicios);
        return json;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String get(@PathVariable Long id) {
        Servicio servicio = uS.get(id);
        String json = format.toJson(servicio);
        return json;
    }

    @PostMapping("/add")
    public void add(@ModelAttribute("Servicio") Servicio servicio) {
        uS.add(servicio);
    }

    @PostMapping("/update")
    public void update(@ModelAttribute("Servicio") Servicio servicio) {
        uS.update(servicio);
    }

    @GetMapping("/delete/{id}")
    public void remove(@PathVariable Long id) {
        uS.remove(id);
    }

    
}
