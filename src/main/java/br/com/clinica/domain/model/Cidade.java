package br.com.clinica.domain.model;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.*;
import lombok.*;
import javax.validation.groups.*;

import br.com.clinica.core.*;

/**
 * 
 * @author Renato Ferreira
 * https://www.linkedin.com/in/renatoredes/
 * https://github.com/renatoredes
 */

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cidade {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade")
	private Long id;
	
	@NotBlank
	@Column(nullable = false,name = "nome_cidade")
	private String nome;
	
	@Valid
	@ConvertGroup(from = Default.class, to = Groups.EstadoId.class)
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;
	
	
}
