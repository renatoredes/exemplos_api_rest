package com.clinica.api.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.api.domain.exception.RecursoEmUsoException;
import com.clinica.api.domain.exception.RecursoNaoEncontradaException;
import com.clinica.api.domain.model.Medico;
import com.clinica.api.domain.repository.IMedicoRepository;
import com.clinica.api.domain.service.MedicoService;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {

	@Autowired
	private IMedicoRepository iMedicoRepository;
	
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping
	public List<Medico> listar() {
		return iMedicoRepository.listar();
	}
	
	@GetMapping("/{medicoId}")
	public ResponseEntity<Medico> buscar(@PathVariable Long medicoId) {
		Medico medico = iMedicoRepository.buscar(medicoId);
		
		if (medico != null) {
			return ResponseEntity.ok(medico);
		}
		
		return ResponseEntity.notFound().build();
	}
	/*
	 * Busca por nome especifico ou letra que conter dentro do nome.
	 * @RequestParam buscar por Query params
	 */
	@GetMapping("/busca-por-nome")
	public List<Medico> cozinhasPorNome(@RequestParam("nome") String nome) {
		return iMedicoRepository.buscarPorNome(nome);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Medico adicionar(@RequestBody Medico medico) {
		return medicoService.salvar(medico);
	}
	
	@PutMapping("/{medicoId}")
	public ResponseEntity<Medico> atualizar(@PathVariable Long medicoId,
			@RequestBody Medico medico) {
		Medico medicoAtual = iMedicoRepository.buscar(medicoId);
		
		if (medicoAtual != null) {
			BeanUtils.copyProperties(medico, medicoAtual, "id");
			
			medicoAtual = medicoService.salvar(medicoAtual);
			return ResponseEntity.ok(medicoAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	 
	@DeleteMapping("/{medicoId}")
	public ResponseEntity<?> remover(@PathVariable Long medicoId) {
		try {
			medicoService.excluir(medicoId);	
			return ResponseEntity.noContent().build();
			
		} catch (RecursoNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (RecursoEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
	}
}
