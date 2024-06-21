package com.cloudioenabler.traning.crud.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoApp {
    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @GetMapping("/env")
    public String home() {
        return "env" + activeProfile;
    }
}
