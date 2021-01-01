package br.com.clinica.domain.model;


import javax.persistence.*;

import lombok.*;

/**
 * 
 * @author Renato Ferreira
 * https://www.linkedin.com/in/renatoredes/
 * https://github.com/renatoredes
 */
@Data
@Embeddable
public class Endereco {
	
	@Column(name = "endereco_cep", length=10)
	private String cep;
	
	@Column(name = "endereco_logradouro", length=50)
	private String logradouro;
	
	@Column(name = "endereco_numero", length=5)
	private String numero;
	
	@Column(name = "endereco_complemento", length=50)
	private String complemento;
	
	@Column(name = "endereco_bairro", length=50)
	private String bairro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;
	
}









