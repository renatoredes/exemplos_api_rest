package br.com.clinica.domain.model;

import javax.persistence.*;

import lombok.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa",length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("P")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public abstract class Pessoa {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length=50)
	private String nome;
	
	@Column(nullable = false,name = "sobre_nome", length=50)
	private String sobreNome;
	
	@Column(nullable = false,name = "nome_mae_paciente", length=50)
	private String nomeMae;
	
	@Column(nullable = false,name = "nome_pai", length=50)
	private String nomePai;
	
	@Column(nullable = false, name = "numero_rg", length=10)
	private String rg;
	
	@Column(nullable = false, name = "numero_cpf",length=11)
	private String cpf;
	
	@Column(nullable = false , name = "telefone_fixo", length=20)
	private String telefoneFixo;
	
	@Column(nullable = false , name = "telefone_celular", length=20)
	private String teleCelular;
	
	@Column(length=50)
	private String email;
	
	@Embedded
	private Endereco endereco;

}
