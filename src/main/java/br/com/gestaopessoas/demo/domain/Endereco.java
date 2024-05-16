package br.com.gestaopessoas.demo.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Endereco implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
    private Number CEP;
    private Number numero;
    private String cidade;
    private String estado;
    
}
