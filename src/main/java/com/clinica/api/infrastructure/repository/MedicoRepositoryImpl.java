package com.clinica.api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.api.domain.model.Medico;
import com.clinica.api.domain.repository.IMedicoRepository;

@Repository
public class MedicoRepositoryImpl implements IMedicoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Medico> listar() {
		return manager.createQuery("from Medico", Medico.class)
				.getResultList();
	}
	
	@Override
	public List<Medico> buscarPorNome(String nome) {
		return manager.createQuery("from Medico where nome like :nome", Medico.class)
			.setParameter("nome", "%" + nome + "%")
			.getResultList();
	}
	
	@Override
	public Medico buscar(Long id) {
		return manager.find(Medico.class, id);
	}
	
	@Transactional
	@Override
	public Medico salvar(Medico medico) {
		return manager.merge(medico);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		Medico medico = buscar(id);
		
		if (medico == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(medico);
	}

}
