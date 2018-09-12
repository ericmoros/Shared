package com.hiberus.dual.crud.controllers;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 */
public class HomeController {

    @GetMapping({ "", "/index" })
    public String index() {
        return "index";
    }
}