package com.clinica.api.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.clinica.api.domain.model.Consulta;
/**
 * 
 * @author Renato
 * Utilizando interface customizada
 *  
 * exemplo do endpoint: http://localhost:8080/consultas/filtra-consulta/descricao/valor-inicial-final?descricao=a&valorInicialConsultaMedica=500&valorFinalConsultaMedica=700
 * 
 */
public interface CustomizedConsultaRepository {

	List<Consulta> buscarConsultasPorDescricaoeValor(String descricao,
			BigDecimal valorInicialConsultaMedica, BigDecimal valorFinalConsultaMedica);

}