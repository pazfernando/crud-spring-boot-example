    package com.cloudioenabler.traning.crud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VulnerableController {
    @GetMapping("/vulnerable")
    public String vulnerable(@RequestParam("user") String user) {
        // Vulnerable a Inyección SQL
        String query = "SELECT * FROM users WHERE username = '" + user + "'";
        // Ejecutar consulta en la base de datos...
        
        return "result";
    }

    @PostMapping("/deserialize")
    public void deserializeObject(@RequestBody Object obj) {
        // Código vulnerable a la deserialización insegura
        // ...
 
 
    }

    @PostMapping("/vulnerable")
    public String vulnerable2(@RequestBody String input) {
        // Vulnerable a XSS (Cross-Site Scripting)
        return "Hello, " + input + "!";
    }
}
