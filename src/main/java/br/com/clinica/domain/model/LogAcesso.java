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
public class LogAcesso {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_log_de_acesso")
	private Long id;
	
	@Column(name = "data_acesso")
	private LocalDate dataAcesso;
	
	@Column(name = "nome_usuario",length=200)
	private String nomeUsuario;
}
