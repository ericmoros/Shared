package com.hiberus.dual.hotel.controladores;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.hiberus.dual.hotel.modelos.habitacion.Habitacion;
import com.hiberus.dual.hotel.servicios.HabitacionServicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HabitacionControlador
 */
@Controller
@RequestMapping({ "/habitaciones", "/habitacion" })
public class HabitacionControlador {
    // Atts
    private Gson format;
    private HabitacionServicio hS;

    // Ctor
    public HabitacionControlador(HabitacionServicio uS) {
        this.hS = uS;
        format = new Gson();
    }

    // Methods
    @GetMapping({ "/all", "" })
    @ResponseBody
    public String getAll() {
        ArrayList<Habitacion> habitaciones = hS.getAll();
        String json = format.toJson(habitaciones);
        return json;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String get(@PathVariable Long id) {
        Habitacion habitacion = hS.get(id);
        String json = format.toJson(habitacion);
        return json;
    }

    @PostMapping("/add")
    public void add(@ModelAttribute("Habitacion") Habitacion habitacion) {
        hS.add(habitacion);
    }

    @PostMapping("/update")
    public void update(@ModelAttribute("Habitacion") Habitacion habitacion) {
        hS.update(habitacion);
    }

    @GetMapping("/delete/{id}")
    public void remove(@PathVariable Long id) {
        hS.remove(id);
    }


}
