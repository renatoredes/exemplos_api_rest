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
public class Medicamento {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medicamento")
	private Long id;
	
	@Column(name = "nome_medicamento",length=100)
	private String nome;
	
	@Column(name = "descricao_substancia",length=200)
	private String descricaoSubstancia;
	/**
	 * indicação da dose adequada de um medicamento.
	 * forma de utilizar os medicamentos.
	 */
	@Column(nullable = false,name = "descricao_posologia", length=200)
	private String descricaoPosologia;
	
	@Column(nullable = false,name = "descricao_laboratorio", length=200)
	private String descricaoLaboratorio;
	
	@Column(nullable = false,name = "descricao_contra_idicacao", length=200)
	private String descricaoContraIdicacao;
	
	@Column(nullable = false,name = "descricao_generico", length=200)
	private String descricaoGenerico;
	

}
