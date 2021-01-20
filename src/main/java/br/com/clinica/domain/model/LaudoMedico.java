package br.com.clinica.domain.model;


import java.time.*;
import java.util.*;

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
public class LaudoMedico {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,name = "descricao_laudo", length=200)
	private String descricaoLaudoMedico;
	

	@Column(name = "data_laudo_medico")
	private LocalDate dataLaudoMedico;
	
	@Column(name = "hora_laudo_medico")
	private LocalTime horaLaudoMedico;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laudoMedico")
	private List<Medico> consultas = new ArrayList<>();
}
