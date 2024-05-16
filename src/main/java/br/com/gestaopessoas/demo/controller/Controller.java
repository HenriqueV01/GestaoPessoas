package br.com.gestaopessoas.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.gestaopessoas.demo.domain.Pessoa;
import br.com.gestaopessoas.demo.services.PessoaService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class Controller {

    @Autowired
	private PessoaService service;

    @GetMapping("/")
    public String getMethodName() {
        return "Olá Mundo!";
    }
    
    @GetMapping(value = "/pessoa/{id}")
    public Optional<Pessoa> findById(@PathVariable Integer id) {
        Optional<Pessoa> pessoa = service.findById(id);
        return pessoa;
    }
    
    
}
