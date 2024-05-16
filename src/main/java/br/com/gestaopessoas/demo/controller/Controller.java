package br.com.gestaopessoas.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {

    @GetMapping("/")
    public String getMethodName() {
        return "Olá Mundo!";
    }
    
    
}
