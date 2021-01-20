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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Clinica {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_clinica",length=100)
	private String nomeClinica;

	@Column(name = "cnpj_clinica",length=11)
	private String cnpjClinica;
	
	@Column(name = "descricao_especialidades",length=50)
	private String descricaoEspecialidades;
	
	@Column(name = "email_clinica",length=50)
	private String emailClinica;

	@Column(name = "telefone_clinica",length=50)
	private String telefone;
	
	@Column(name = "numero_whatsapp_clinica",length=20)
	private String numerowhatsapp;
	
	@Embedded
	private Endereco endereco;


}
