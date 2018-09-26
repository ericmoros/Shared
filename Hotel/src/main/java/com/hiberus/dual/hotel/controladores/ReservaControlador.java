package com.hiberus.dual.hotel.controladores;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.hiberus.dual.hotel.modelos.hotel.Reserva;
import com.hiberus.dual.hotel.servicios.ReservaServicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ReservaControlador
 */
@Controller
@RequestMapping({ "/reservas", "/reserva" })
public class ReservaControlador {
    // Atts
    private Gson format;
    private ReservaServicio rS;

    // Ctor
    public ReservaControlador(ReservaServicio rS) {
        this.rS = rS;
        format = new Gson();
    }

    // Methods
    @GetMapping({ "/all", "" })
    @ResponseBody
    public String getAll() {
        ArrayList<Reserva> reservas = rS.getAll();
        String json = format.toJson(reservas);
        return json;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String get(@PathVariable Long id) {
        Reserva reserva = rS.get(id);
        String json = format.toJson(reserva);
        return json;
    }

    @PostMapping("/add")
    public void add(@ModelAttribute("Reserva") Reserva reserva) {
        rS.add(reserva);
    }

    @PostMapping("/update")
    public void update(@ModelAttribute("Reserva") Reserva reserva) {
        rS.update(reserva);
    }

    @GetMapping("/delete/{id}")
    public void remove(@PathVariable Long id) {
        rS.remove(id);
    }

}