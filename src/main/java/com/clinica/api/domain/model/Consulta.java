package com.clinica.api.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Consulta {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao_consulta", nullable = false)
	private String descricao;

	@Column(name = "valor_consulta", nullable = false)
	private BigDecimal valorConsulta;

	/**
	 * Este relacionamento indica que muitas consulta pode ser realizada por 1
	 * medico.
	 */
	@ManyToOne
	@JoinColumn(name = "id_medico", nullable = false)
	private Medico medico;

	public Consulta() {

	}

	public Consulta(Long id, String descricao, BigDecimal valorConsulta, Medico medico) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valorConsulta = valorConsulta;
		this.medico = medico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(BigDecimal valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result + ((valorConsulta == null) ? 0 : valorConsulta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (valorConsulta == null) {
			if (other.valorConsulta != null)
				return false;
		} else if (!valorConsulta.equals(other.valorConsulta))
			return false;
		return true;
	}
	
	
}
