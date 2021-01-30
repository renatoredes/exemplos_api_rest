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
	private Long id;
	
	@Column(name = "data_consulta")
	private LocalDate dataConsulta;
	
	@Column(name = "hora_consulta")
	private LocalTime horaConsulta;
	
	@Column(name = "descricao_consulta",length=200)
	private String descricaoConsulta;
	
	@ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
	private Medico medico;
	

	@ManyToOne
    @JoinColumn(name = "paciente_id")
	private Paciente paciente;

}
