package com.clinica.api.domain.repository.specification;

import java.math.BigDecimal;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

import com.clinica.api.domain.model.Consulta;





/**
 * ConsultaSpecification - Querys de consultas implementando Criteria Querys com Lambdas...
 */
public class ConsultaSpecification {

	
	public static Specification<Consulta> porIDConsulta(Long idConsulta) {
		if (idConsulta == null) {
			return null;
		} else {
			return (root, query, cb) -> cb.equal(root.get("id"), idConsulta);
		}
	}
	
	
	
	public static Specification<Consulta> porDescricao(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			return null;
		} else {
			return (root, query, cb) -> cb.like(cb.lower(root.get("descricao")),
					"%" + descricao.toLowerCase() + "%");
		}
	}

	
	
	public static Specification<Consulta> porValorConsulta( BigDecimal valorConsulta) {
		if (valorConsulta == null) {
			return null;
		} else {
			return (root, query, cb) -> cb.equal(root.get("valorConsulta"), valorConsulta);
		}
	}
	
	
	
	public static Specification<Consulta> porMedico(Long idMedico) {
		if (idMedico == null) {
			return null;
		} else {
			return (root, query, cb) -> {
				Join<Object, Object> join = root.join("medico");
				return cb.equal(join.get("id"), idMedico);
			};
		}
	}
	
	
}
