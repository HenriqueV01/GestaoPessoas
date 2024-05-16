package br.com.gestaopessoas.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gestaopessoas.demo.domain.Pessoa;
import br.com.gestaopessoas.demo.services.PessoaService;

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

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
	private PessoaService service;

    @GetMapping("/")
    public ResponseEntity<List<Pessoa>> findAll() {        
        List<Pessoa> listPessoas = service.findAll();
        return ResponseEntity.ok().body(listPessoas);
    }
    
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        Optional<Pessoa> pessoa = service.findById(id);
        return ResponseEntity.ok().body(pessoa.get());
    }

    @PostMapping("/")
    public ResponseEntity<Void> insert(@Validated @RequestBody Pessoa pessoa) {
        Pessoa objPessoa = service.insert(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objPessoa.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Pessoa pessoa, @PathVariable Integer id) {
		pessoa.setId(id);
        service.update(pessoa);
		return ResponseEntity.noContent().build();
    }
    
    
    
}
