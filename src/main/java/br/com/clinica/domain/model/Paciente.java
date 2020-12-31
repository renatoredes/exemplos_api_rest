package br.com.clinica.domain.model;

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
public class Paciente {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente")
	private Long idPaciente;
	
	@Column(nullable = false,name = "nome_paciente", length=50)
	private String nomePaciente;
	
	@Column(nullable = false,name = "sobre_nome_paciente", length=50)
	private String sobreNomePaciente;
	
	@Column(nullable = false, name = "rg_paciente", length=10)
	private String rgPaciente;
	
	@Column(nullable = false, name = "cpf_paciente",length=11)
	private String cpfPaciente;
	
	@Column(nullable = false,name = "nome_mae_paciente", length=50)
	private String nomeMaePaciente;
	
	@Column(nullable = false,name = "nome_pae_paciente", length=50)
	private String nomePaePaciente;
	
	@Column(name = "numero_carteira")
	private Long numeroCarteira;
	
	@Column(name = "email_paciente", length=100)
	private String emailPaciente;
	
	
}
