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
public class Medico {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private Long id;
	
	@Column(nullable = false,name = "nome_medico", length=50)
	private String nome;
	

	@Column(nullable = false,name = "sobre_nome", length=50)
	private String sobreNome;
	
	@Column(nullable = false, name = "rg_medico", length=10)
	private String rgMedico;
	
	@Column(nullable = false, name = "cpf_medico",length=11)
	private String cpfMedico;
	
	@Column(nullable = false , name = "crm_medico", length=7)
	private String crmMedico;
	
	@Column(nullable = false , name = "especialidade_medica", length=200)
	private String especialidade;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medico")
	private List<Consulta> consultas = new ArrayList<>();
}
