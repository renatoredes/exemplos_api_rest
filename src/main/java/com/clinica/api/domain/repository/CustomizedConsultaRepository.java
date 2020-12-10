package com.clinica.api.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.clinica.api.domain.model.Consulta;
/**
 * 
 * @author Renato
 * Repositorio customizado
 *  
 * 
 */
public interface CustomizedConsultaRepository {

 /**
 * 
 * @param descricao 
 * @param valorInicialConsultaMedica
 * @param valorFinalConsultaMedica
 * @return consulta utilizando todos os parametros caso não preencher todos retornará uma lista vazia
 *
 * exemplo do endpoint: http://localhost:8080/consultas/filtra-consulta/descricao/valor-inicial-final?descricao=a&valorInicialConsultaMedica=500&valorFinalConsultaMedica=700
 */
 
	List<Consulta> buscarConsultasPorDescricaoeValor(String descricao,
			BigDecimal valorInicialConsultaMedica, BigDecimal valorFinalConsultaMedica);

	/**
	 * 
	 * @param descricao
	 * @param valorInicialConsultaMedica
	 * @param valorFinalConsultaMedica
	 * @return retorna uma consulta caso algum parametro for preenchido não é obrigatorio preencher todos os campos
	 */
	List<Consulta> buscarConsultasPorDescricaoeValorDinamicamente(String descricao,
			BigDecimal valorInicialConsultaMedica, BigDecimal valorFinalConsultaMedica);

	/**
	 * neste exemplo utilizamos APO Criteriaquery:
	 * O usuario deve preencher algum valor no filtro não é obrigatorio preencher todos os campos dos parametros
	 * 
	 * 
	 * estamos customizado repositorio CustomizedConsultaRepository
	 */
	List<Consulta> buscarConsultasMedicasCriteriaquery(String descricao, BigDecimal valorInicialConsultaMedica,
			BigDecimal valorFinalConsultaMedica);	
	
	

}