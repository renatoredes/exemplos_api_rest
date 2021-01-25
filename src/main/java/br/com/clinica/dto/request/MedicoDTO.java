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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "laudo_id")
	private LaudoMedico laudoMedico;

	// -- um medico pode realizar muitas consultas --//
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medico")
	@Valid
	@NotEmpty
	private List<Consulta> consultas = new ArrayList<>();

	// -- um medico pode gerar muitas receitas --//
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medico", cascade = CascadeType.ALL)
	private List<Receita> receitas = new ArrayList<>();

	private String email;
}
