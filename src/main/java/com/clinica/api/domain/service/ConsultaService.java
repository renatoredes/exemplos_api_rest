package com.clinica.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.api.domain.exception.RecursoNaoEncontradaException;
import com.clinica.api.domain.model.Consulta;
import com.clinica.api.domain.model.Medico;
import com.clinica.api.domain.repository.IConsultaRepository;
import com.clinica.api.domain.repository.IMedicoRepository;

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

}
