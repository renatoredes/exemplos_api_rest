package com.clinica.api.domain.repository;

import java.util.List;

import com.clinica.api.domain.model.Consulta;

public interface IConsultaRepository {

	List<Consulta> listar();
	Consulta buscar(Long id);
	Consulta salvar(Consulta consulta);
	void remover(Consulta consulta);
	
}
