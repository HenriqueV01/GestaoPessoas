package br.com.gestaopessoas.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaopessoas.demo.domain.Pessoa;
import br.com.gestaopessoas.demo.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;	
	
	public Optional<Pessoa> findById(Integer id) {
		
		Optional<Pessoa> obj = repo.findById(id);
		
		return obj;
	}
}
