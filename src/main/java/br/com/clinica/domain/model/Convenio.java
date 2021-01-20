package br.com.clinica.domain.model;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

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
public class Convenio {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,name = "nome_convenio", length=100)
	private String nomeCovenio;
	
	@Column(name = "data_inicio")
	private LocalDate dataInicio;
	
	@Column(nullable = false,name = "descricao_regiao", length=100)
	private String descricaoRegiao;
	
	//-- um medico pode ter muitas pacientes --//
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "convenio", cascade = CascadeType.ALL)
	private List<Paciente> pacientes = new ArrayList<>();
	
}
