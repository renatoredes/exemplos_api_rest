package br.com.clinica.domain.model;


import javax.persistence.*;

import lombok.Data;

/**
 * 
 * @author Renato Ferreira
 * https://www.linkedin.com/in/renatoredes/
 * https://github.com/renatoredes
 */
@Data
@Embeddable
public class Endereco {
	
	@Column(length=10)
	private String cep;
	
	@Column(length=50)
	private String logradouro;
	
	@Column(length=5)
	private String numero;
	
	@Column(length=50)
	private String complemento;
	
	@Column(length=50)
	private String bairro;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;
		
}









