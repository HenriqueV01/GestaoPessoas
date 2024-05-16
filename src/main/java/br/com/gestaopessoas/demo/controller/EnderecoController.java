package br.com.gestaopessoas.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gestaopessoas.demo.domain.Endereco;
import br.com.gestaopessoas.demo.services.EnderecoService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
	private EnderecoService service;

    @GetMapping("/")
    public ResponseEntity<List<Endereco>> findAll() {        
        List<Endereco> listEnderecos = service.findAll();
        return ResponseEntity.ok().body(listEnderecos);
    }
    
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
        Optional<Endereco> endereco = service.findById(id);
        return ResponseEntity.ok().body(endereco.get());
    }

    @PostMapping("/")
    public ResponseEntity<Void> insert(@Validated @RequestBody Endereco endereco) {
        Endereco objEndereco = service.insert(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objEndereco.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Endereco endereco, @PathVariable Integer id) {
		endereco.setId(id);
        service.update(endereco);
		return ResponseEntity.noContent().build();
    }   
    
}
