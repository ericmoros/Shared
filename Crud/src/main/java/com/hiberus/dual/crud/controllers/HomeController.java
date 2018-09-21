package com.hiberus.dual.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 */
@Controller
public class HomeController {
    @GetMapping({ "/", "/button" })
    public String index() {
        return "button";
    }

    @GetMapping({ "/index", "/home" })
    public String home() {
        return "index";
    }
}