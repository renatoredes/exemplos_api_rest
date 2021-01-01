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
public class Exame {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_exame")
	private Long id;

	@Column(nullable = false,name = "nome_exame", length=200)
	private String nomeExame;
	
	@Column(nullable = false,name = "descricao_exame", length=200)
	private String descricaoExame;
	
	@Column(nullable = false,name = "data_exame")
	private LocalDate dataExame;
	
	@Column(nullable = false,name = "data_resultado_exame")
	private LocalDate dataResultadoExame;
	
	@Column(nullable = false,name = "observacao", length=200)
	private String observacao;
	
	
	
	
}
