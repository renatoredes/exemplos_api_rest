package com.clinica.api.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.clinica.api.domain.model.Consulta;
import com.clinica.api.domain.repository.CustomizedConsultaRepository;

/**
 * 
 * @author Renato
 * Implementação repositorio customizado o nome precisa ser o mesmo da interface + Impl
 *
 */

@Repository
public class ConsultaRepositoryImpl implements CustomizedConsultaRepository  {

	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * neste exemplo
	 * Todos os valores dos parametros devem ser prenchidos para retornar uma lista de consultas
	 * caso contrario a consulta retornará uma lista vazia 
	 * 
	 */
	
	@Override
	public List<Consulta> buscarConsultasPorDescricaoeValor(String descricao, 
			BigDecimal valorInicialConsultaMedica, BigDecimal valorFinalConsultaMedica) {
		
		String jpql = "from Consulta where descricao like :descricao "
				+ "and valorConsulta between :valorInicialConsultaMedica and :valorFinalConsultaMedica";
		/**
		 * parametros fixos na consulta
		 */
		return manager.createQuery(jpql, Consulta.class)
				.setParameter("descricao", "%" + descricao + "%")
				.setParameter("valorInicialConsultaMedica", valorInicialConsultaMedica)
				.setParameter("valorFinalConsultaMedica", valorFinalConsultaMedica)
				.getResultList();
	}
	
	/**
	 * neste exemplo utilizamos JPQL:
	 * O usuario deve preencher algum valor no filtro não é obrigatorio preencher todos os campos dos parametros
	 * devem ser prenchido no minimo um valor para retornar uma lista de consultas medica
	 * 
	 * estamos customizado repositorio CustomizedConsultaRepository
	 */
	@Override
	public List<Consulta> buscarConsultasPorDescricaoeValorDinamicamente(String descricao, 
			BigDecimal valorInicialConsultaMedica, BigDecimal valorFinalConsultaMedica) {
		
		var jpql = new StringBuilder();
		jpql.append("from Consulta where 0 = 0 ");
		
		var parametros = new HashMap<String, Object>();
		
		/*verifica se temos algum texto no parametro se tiver faz alguma coisa */
		if (StringUtils.hasLength(descricao)) {
			jpql.append("and descricao like :descricao ");
			parametros.put("descricao", "%" + descricao + "%");
		}
		if (valorInicialConsultaMedica != null) {
			jpql.append("and valorConsulta >= :valorInicialConsultaMedica ");
			parametros.put("valorInicialConsultaMedica", valorInicialConsultaMedica);
		}
		
		if (valorFinalConsultaMedica != null) {
			jpql.append("and valorConsulta <= :valorFinalConsultaMedica ");
			parametros.put("valorFinalConsultaMedica", valorFinalConsultaMedica);
		}
		
		TypedQuery<Consulta> query = manager.createQuery(jpql.toString(), Consulta.class);
		
		parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

		return query.getResultList();
	}
	
	/***
	 * a mesma consulta JPQL sendo que agora Utilizando criteriaquery
	 */
	
	@Override
	public List<Consulta> buscarConsultasMedicasCriteriaquery(String descricao, 
			BigDecimal valorInicialConsultaMedica, BigDecimal valorFinalConsultaMedica) {
		var builder = manager.getCriteriaBuilder();
		
		var criteria = builder.createQuery(Consulta.class);
		var root = criteria.from(Consulta.class);

		var predicates = new ArrayList<Predicate>();
		/**
		 * "descricao"  atributo da classe
		 *  descricao segundo é referente ao parametro do metodo
		 */
		if (StringUtils.hasText(descricao)) {
			predicates.add(builder.like(root.get("descricao"), "%" + descricao + "%"));
		}
		
		if (valorInicialConsultaMedica != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("valorConsulta"), valorInicialConsultaMedica));
		}
		
		if (valorFinalConsultaMedica != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("valorConsulta"), valorFinalConsultaMedica));
		}
		
		criteria.where(predicates.toArray(new Predicate[0]));
		
		var query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	
}






























