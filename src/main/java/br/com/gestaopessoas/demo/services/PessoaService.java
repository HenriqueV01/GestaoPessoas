package br.com.gestaopessoas.demo.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaopessoas.demo.domain.Pessoa;
import br.com.gestaopessoas.demo.repositories.EnderecoRepository;
import br.com.gestaopessoas.demo.repositories.PessoaRepository;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
    
    @Autowired
	private EnderecoRepository enderecoRepository;
	
	public Optional<Pessoa> findById(Integer id) {
		
		Optional<Pessoa> obj = pessoaRepository.findById(id);		
		return obj;
	}

    @Transactional
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		obj = pessoaRepository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

    public Pessoa update(Pessoa obj) {
		Optional<Pessoa> newPessoa = pessoaRepository.findById(obj.getId());
		return pessoaRepository.save(newPessoa.get());
	}

    public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}

}
