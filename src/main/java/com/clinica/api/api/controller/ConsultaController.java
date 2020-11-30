package com.clinica.api.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.api.domain.exception.RecursoNaoEncontradaException;
import com.clinica.api.domain.model.Consulta;
import com.clinica.api.domain.repository.IConsultaRepository;
import com.clinica.api.domain.service.ConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultaController {

	@Autowired
	private IConsultaRepository iConsultaRepository;
	
	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping
	public List<Consulta> listar() {
		return iConsultaRepository.listar();
	}
	
	@GetMapping("/{consultaId}")
	public ResponseEntity<Consulta> buscar(@PathVariable Long consultaId) {
		Consulta consulta = iConsultaRepository.buscar(consultaId);
		
		if (consulta != null) {
			return ResponseEntity.ok(consulta);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Consulta consulta) {
		try {
			consulta = consultaService.salvar(consulta);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(consulta);
		} catch (RecursoNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	/**
	 * 
	 * @param consultaId recebe o código a ser atualizado
	 * @param consulta
	 * @return os dados da consulta médica atualizada
	 */
	@PutMapping("/{consultaId}")
	public ResponseEntity<?> atualizar(@PathVariable Long consultaId,
			@RequestBody Consulta consulta) {
		try {
			Consulta consultaMedicaAtual = iConsultaRepository.buscar(consultaId);
			
			if (consultaMedicaAtual != null) {
				BeanUtils.copyProperties(consulta, consultaMedicaAtual, "id");
				
				consultaMedicaAtual = consultaService.salvar(consultaMedicaAtual);
				return ResponseEntity.ok(consultaMedicaAtual);
			}
			
			return ResponseEntity.notFound().build();
		
		} catch (RecursoNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@PatchMapping("/{consultaId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long consultaId,
			@RequestBody Map<String, Object> campos) {
		Consulta consultaAtual = iConsultaRepository.buscar(consultaId);
		
		if (consultaAtual == null) {
			return ResponseEntity.notFound().build();
		}
		
		merge(campos, consultaAtual);
		
		return atualizar(consultaId, consultaAtual);
	}

	private void merge(Map<String, Object> dadosOrigem, Consulta consultaDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Consulta consultaOrigem = objectMapper.convertValue(dadosOrigem, Consulta.class);
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Consulta.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, consultaOrigem);
			
			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);
			
			ReflectionUtils.setField(field, consultaDestino, novoValor);
		});
	}
	
}
