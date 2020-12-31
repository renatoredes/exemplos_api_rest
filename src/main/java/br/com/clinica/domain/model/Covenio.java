package br.com.clinica.domain.model;

import java.time.*;
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
public class Covenio {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_covenio")
	private Long idConsulta;
	
	@Column(nullable = false,name = "nome_convenio", length=100)
	private String nomeCovenio;
	
	@Column(name = "data_inicio")
	private LocalDate dataInicio;
	
	@Column(nullable = false,name = "descricao_regiao", length=100)
	private String descricaoRegiao;
	
	
}
