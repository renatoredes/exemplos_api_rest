package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinica.domain.model.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
