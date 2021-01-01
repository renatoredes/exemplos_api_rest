package br.com.clinica.domain.model;

import java.time.LocalDate;

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
public class Receita {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receita")
	private Long id;
	
	@Column(name = "descricao_receita",length=100)
	private String descricao;

	@Column(name = "data_receita")
	private LocalDate dataReceita;
	
	/**
	 * indicação da dose adequada de um medicamento.
	 * forma de utilizar os medicamentos.
	 */
	@Column(nullable = false,name = "descricao_posologia", length=200)
	private String descricaoPosologia;
	
	@Column(nullable = false,name = "observacao", length=200)
	private String observacao;
}
