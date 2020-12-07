package com.clinica.api.infrastructure.repository;

import java.math.BigDecimal;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.clinica.api.domain.model.Consulta;
import com.clinica.api.domain.repository.CustomizedConsultaRepository;

/**
 * 
 * @author Renato
 * o nome precisa ser o mesmo da interface + Impl
 *
 */

@Repository
public class ConsultaRepositoryImpl implements CustomizedConsultaRepository  {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<Consulta> buscarConsultasPorDescricaoeValor(String descricao, 
			BigDecimal valorInicialConsultaMedica, BigDecimal valorFinalConsultaMedica) {
		
		String jpql = "from Consulta where descricao like :descricao "
				+ "and valorConsulta between :valorInicialConsultaMedica and :valorFinalConsultaMedica";
		
		return manager.createQuery(jpql, Consulta.class)
				.setParameter("descricao", "%" + descricao + "%")
				.setParameter("valorInicialConsultaMedica", valorInicialConsultaMedica)
				.setParameter("valorFinalConsultaMedica", valorFinalConsultaMedica)
				.getResultList();
	}
	
}
