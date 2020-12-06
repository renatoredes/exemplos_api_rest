package com.clinica.api.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinica.api.domain.model.Consulta;

/***
 * 
 * @author Renato
 * Exemplos de utilização de consultas com Spring Data
 * você deve modificar os nomes de métodos conforme padrões e nescessidades.
 *
 */
@Repository
public interface IConsultaRepository extends JpaRepository<Consulta, Long> {

	/**
	 * Utilizando Keyword do Spring boot
	 */

	/*
	 * @param valorInicial  passamos um valor qualquer no valor inicial e final
	 * @param valorFinal
	 * @return retorna uma lista de consultas relacionada ao valor inicial e final que foi informado no parametro
	 * 
	 * você deve mudar os nomes de metodos e endpoint
	 * Estão descritos dessa forma para facilitar o entendimento
	 */
	List<Consulta> findByValorConsultaBetween(BigDecimal valorInicial, BigDecimal valorFinal);

	/**
	 * 
	 * @param nome busca nome do medico relacionado a consulta
	 * @param medicoId relacionado a consulta
	 * @return uma lista de medicos 
	 * 
	 * você deve mudar os nomes de metodos estão descritos dessa forma para facilitar o entendimento
	 */
	List<Consulta> findByDescricaoContainingAndMedicoId(String descricao, Long medicoId);
	
	/**
	 * Customizando consultas com @Query e JPQL 
	 * 
	 * @param descricao da consulta
	 * @param medicoId é o id do medico relacionado
	 * @return uma lista de consultas relacionada ao id do medico cadastrado
	 */
	@Query("from Consulta where descricao like %:descricao% and medico.id = :id")
	List<Consulta> descricaoConsultaIdMedico (String descricao, @Param("id") Long medicoId);
	
	
	/**
	 * Customizando consultas utilizando Arquivo de mapeamento orm.xml 
	 * 
	 * @param descricao da consulta
	 * @param medicoId é o id do medico relacionado a uma consulta medica
	 * @return retorna uma lista de consultas relacionada ao id do medico cadastrado
	 */
	List<Consulta> descricaoConsultaIdMedicoRelacionado (String descricao, @Param("id") Long medicoId);
	
	
}
