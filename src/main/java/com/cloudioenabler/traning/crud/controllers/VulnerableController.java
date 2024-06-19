    package com.cloudioenabler.traning.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VulnerableController {
    @GetMapping("/vulnerable")
    public String vulnerable(@RequestParam("user") String user) {
        // Vulnerable a Inyección SQL
        String query = "SELECT * FROM users WHERE username = '" + user + "'";
        // Ejecutar consulta en la base de datos...
        
        return "result";
    }
}
