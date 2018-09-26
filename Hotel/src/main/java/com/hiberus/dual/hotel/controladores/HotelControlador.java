package com.hiberus.dual.hotel.controladores;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.hiberus.dual.hotel.modelos.hotel.Hotel;
import com.hiberus.dual.hotel.servicios.HotelServicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HotelControlador
 */
@Controller
@RequestMapping({ "/hoteles", "/hotel" })
public class HotelControlador {
    // Atts
    private Gson format;
    private HotelServicio hS;

    // Ctor
    public HotelControlador(HotelServicio oS) {
        this.hS = oS;
        format = new Gson();
    }

    // Methods
    @GetMapping({ "/all", "" })
    @ResponseBody
    public String getAll() {
        ArrayList<Hotel> hoteles = hS.getAll();
        String json = format.toJson(hoteles);
        return json;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String get(@PathVariable Long id) {
        Hotel hotel = hS.get(id);
        String json = format.toJson(hotel);
        return json;
    }

    @PostMapping("/add")
    public void add(@ModelAttribute("Hotel") Hotel hotel) {
        hS.add(hotel);
    }

    @PostMapping("/update")
    public void update(@ModelAttribute("Hotel") Hotel hotel) {
        hS.update(hotel);
    }

    @GetMapping("/delete/{id}")
    public void remove(@PathVariable Long id) {
        hS.remove(id);
    }

}