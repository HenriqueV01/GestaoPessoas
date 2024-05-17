package br.com.gestaopessoas.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaopessoas.demo.domain.Endereco;
import br.com.gestaopessoas.demo.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
	
    @Autowired
	private EnderecoRepository enderecoRepository;
	
	public Optional<Endereco> findById(Integer id) {
		
		Optional<Endereco> obj = enderecoRepository.findById(id);		
		return obj;
	}

    @Transactional
	public Endereco insert(Endereco obj) {
		//obj.setId(null);
		System.out.println(obj.getId());
		obj = enderecoRepository.save(obj);
		return obj;
	}

    public Endereco update(Endereco obj) {
		//Optional<Endereco> newEndereco = enderecoRepository.findById(obj.getId());
		return enderecoRepository.save(obj);
	}

    public List<Endereco> findAll(){
		return enderecoRepository.findAll();
	}

}
