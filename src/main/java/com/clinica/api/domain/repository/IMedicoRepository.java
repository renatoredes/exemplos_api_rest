package com.clinica.api.domain.repository;

import java.util.List;

import com.clinica.api.domain.model.Medico;

public interface IMedicoRepository {

	List<Medico> listar();
	Medico buscar(Long id);
	Medico salvar(Medico medico);
	void remover(Long id);
	List<Medico> buscarPorNome(String nome);
	
}
