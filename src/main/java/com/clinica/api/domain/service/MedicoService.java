package com.clinica.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.clinica.api.domain.exception.RecursoEmUsoException;
import com.clinica.api.domain.exception.RecursoNaoEncontradaException;
import com.clinica.api.domain.model.Medico;
import com.clinica.api.domain.repository.IMedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private IMedicoRepository iMedicoRepository;

	
	/**
	 * método serve tanto para salvar quanto para atualizar
	 * Utilizando Spring Data
	 */
	public Medico salvar(Medico medico) {
		return iMedicoRepository.save(medico);
	}

	public void excluir(Long medicoId) {
		try {
			iMedicoRepository.deleteById(medicoId);

		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradaException(
					String.format("Não existe cadastro de médico com código %d", medicoId));

		} catch (DataIntegrityViolationException e) {
			throw new RecursoEmUsoException(
					String.format("Medico de código %d não pode ser removido, pois está em uso", medicoId));
		}
	}

}
