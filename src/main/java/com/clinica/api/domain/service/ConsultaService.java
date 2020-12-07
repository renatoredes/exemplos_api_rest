package com.clinica.api.domain.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.clinica.api.domain.exception.RecursoNaoEncontradaException;

import com.clinica.api.domain.model.Consulta;
import com.clinica.api.domain.model.Medico;
import com.clinica.api.domain.repository.IConsultaRepository;
import com.clinica.api.domain.repository.IMedicoRepository;
import com.clinica.api.domain.repository.specification.ConsultaSpecification;



@Service
public class ConsultaService {

	@Autowired
	private IConsultaRepository iConsultaRepository;

	@Autowired
	private IMedicoRepository iMedicoRepository;

	/**
	 * 
	 *  método serve tanto para salvar quanto para atualizar
	 * 
	 */
	public Consulta salvar(Consulta consulta) {
		Long medicoId = consulta.getMedico().getId();
		
		Medico medico = iMedicoRepository.findById(medicoId)
				.orElseThrow(() -> new RecursoNaoEncontradaException(
						String.format("Não existe cadastrado medico de código %d", medicoId)));
		consulta.setMedico(medico);
		
		return iConsultaRepository.save(consulta);
	}
	
	
	public  List<Consulta> listarConsultas(Long idConsulta, String descricao, BigDecimal valorConsulta, Long idMedido){
		
		
		Specification<Consulta> querySpecification = Specification.where(
				
				ConsultaSpecification.porIDConsulta(idConsulta))	
				.and(ConsultaSpecification.porDescricao(descricao)) 		
				.and(ConsultaSpecification.porValorConsulta(valorConsulta))
				.and(ConsultaSpecification.porMedico(idMedido)
						
	 ); //Fim montagem da query
		
		
		return iConsultaRepository.findAll(querySpecification);
		
		
	}
	
	
	
	

}
