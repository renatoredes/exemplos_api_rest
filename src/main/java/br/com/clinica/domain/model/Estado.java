package br.com.clinica.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import br.com.clinica.core.Groups;
import lombok.*;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Estado {


	@NotNull(groups = Groups.EstadoId.class)
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
}
