package com.clinica.api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.api.domain.model.Consulta;
import com.clinica.api.domain.repository.IConsultaRepository;

@Repository
public class ConsultaRepositoryImpl implements IConsultaRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Consulta> listar() {
		return manager.createQuery("from Consulta", Consulta.class)
				.getResultList();
	}
	
	@Override
	public Consulta buscar(Long id) {
		return manager.find(Consulta.class, id);
	}
	
	@Transactional
	@Override
	public Consulta salvar(Consulta consulta) {
		return manager.merge(consulta);
	}
	
	@Transactional
	@Override
	public void remover(Consulta consulta) {
		consulta = buscar(consulta.getId());
		manager.remove(consulta);
	}

}
