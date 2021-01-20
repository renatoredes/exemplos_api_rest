package br.com.clinica.domain.model;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.*;
import javax.validation.groups.*;

import br.com.clinica.core.Groups;
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
public class Cidade {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false,name = "nome_cidade")
	private String nome;
	
//	@Embedded
//	private Endereco endereco;
	
	@Valid
	@ConvertGroup(from = Default.class, to = Groups.EstadoId.class)
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;
	
	
}
