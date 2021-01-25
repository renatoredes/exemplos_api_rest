package br.com.clinica.domain.model;

import java.util.*;

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
public class Medico{

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length=50)
	private String nome;
	
	@Column(nullable = false,name = "sobre_nome", length=50)
	private String sobreNome;
	
	@Column(name = "rg_documento", length=10)
	private String rg;
	
	@Column(name = "cpf_documento",length=11)
	private String cpf;
		
	@Column(name = "crm_medico", length=7)
	private String crmMedico;
	
	@Column(nullable = false , name = "especialidade_medica", length=100)
	private String especialidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laudo_id")
	private LaudoMedico laudoMedico;

	//-- um medico pode realizar muitas consultas --//
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medico")
	private List<Consulta> consultas = new ArrayList<>();
	
	//-- um medico pode gerar muitas receitas --//
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medico", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Receita> receitas = new ArrayList<>();
	
	@Column(length=50)
	private String email;
	
	
	
}
