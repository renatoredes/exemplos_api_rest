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

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaudoMedico {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,name = "descricao_laudo", length=200)
	private String descricaoLaudoMedico;
	

//	@Column(name = "data_laudo_medico")
//	private LocalDate dataLaudoMedico;
//	
//	@Column(name = "hora_laudo_medico")
//	private LocalTime horaLaudoMedico;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "medico_id", nullable = false)
//	private Medico medico;
}
