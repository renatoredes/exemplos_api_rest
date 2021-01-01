package br.com.clinica.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

import br.com.clinica.core.Groups;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Estado {

	@NotNull(groups = Groups.EstadoId.class)
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
}
