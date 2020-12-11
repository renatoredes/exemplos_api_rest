package com.clinica.api.infrastructure.specification;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.clinica.api.domain.model.Consulta;

public class ConsultaSpecification {

	public static Specification<Consulta> consultaGratis() {
		return (root, query, builder) -> 
			builder.equal(root.get("valorConsulta"), BigDecimal.ZERO);
	}
	
	public static Specification<Consulta> budcarPorNomeOuLetras(String descricao) {
		return (root, query, builder) ->
			builder.like(root.get("descricao"), "%" + descricao + "%");
	}
	
}

