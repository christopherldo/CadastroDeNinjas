package dev.java10x.cadastrodeninjas.ninjas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/")
    public String welcome() {
        return new String("Hello, World!");
    }
}
