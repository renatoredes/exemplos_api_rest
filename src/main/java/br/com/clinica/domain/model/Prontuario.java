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
public class Prontuario {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prontuario")
	private Long id;

	@Column(nullable = false,name = "descricao_medicamento", length=200)
	private String descricaoMedicamento;

	/**
	 * indicação da dose adequada de um medicamento.
	 * forma de utilizar os medicamentos.
	 */
	@Column(nullable = false,name = "descricao_posologia", length=200)
	private String descricaoPosologia;

	@Column(nullable = false,name = "data_inicio_medicamento")
	private LocalDate dataInicioMedicamento;
	
	@Column(nullable = false,name = "data_final_medicamento")
	private LocalDate dataFinalMedicamento;
	
	@Column(nullable = false,name = "observacao", length=200)
	private String observacao;
	
	
	
	
}
