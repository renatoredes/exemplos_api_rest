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
public class Funcionario {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Long id;
	
	@Column(nullable = false,name = "nome_funcionario", length=50)
	private String nome;
	

	@Column(nullable = false,name = "sobre_funcionario", length=50)
	private String sobreNome;
	
	@Column(nullable = false, name = "rg_funcionario", length=10)
	private String rgMedico;
	
	@Column(nullable = false, name = "cpf_funcionario",length=11)
	private String cpfMedico;	

	
}
