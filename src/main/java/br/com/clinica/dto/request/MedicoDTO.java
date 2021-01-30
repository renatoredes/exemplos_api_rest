package br.com.clinica.dto.request;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.clinica.domain.model.Consulta;
import br.com.clinica.domain.model.LaudoMedico;
import br.com.clinica.domain.model.Receita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {

	private Long id;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String nome;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String sobreNome;

	@Size(max = 10)
	private String rg;

	@CPF
	private String cpf;

	@NotEmpty
	@Size(max = 50)
	private String crmMedico;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String especialidade;

	private String email;

	@Valid
	@NotEmpty
	private List<LaudoMedicoDTO> laudoMedicos;

}
