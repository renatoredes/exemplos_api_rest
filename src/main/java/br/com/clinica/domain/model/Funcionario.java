package br.com.clinica.domain.model;

import javax.persistence.*;



@DiscriminatorValue("Funcionario")
@Entity
public class Funcionario extends Pessoa {

	@Column(name = "matricula_funcionario",length=50)
	private String matriculaFuncionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_funcionario_id")
	private CargoFuncionario cargoFuncionario;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinica_id")
	private Clinica clinica;

	
}
