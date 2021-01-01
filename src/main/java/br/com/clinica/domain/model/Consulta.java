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
public class Consulta {


	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consulta")
	private Long id;
	
	@Column(name = "data_consulta")
	private LocalDate dataConsulta;
	
	@Column(name = "hora_consulta")
	private LocalTime horaConsulta;
	
	@Column(name = "descricao_consulta",length=200)
	private String descricaoConsulta;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
	private Medico medico;
}
