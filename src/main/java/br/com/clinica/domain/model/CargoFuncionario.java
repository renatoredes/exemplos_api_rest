package br.com.clinica.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

/**
 * 
 * @author Renato Ferreira https://www.linkedin.com/in/renatoredes/
 *         https://github.com/renatoredes
 */

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CargoFuncionario {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false, name = "nome_cargo")
	private String nomeCargo;

	@NotBlank
	@Column(nullable = false, name = "descricao_cargo")
	private String descricaoCargo;

}
