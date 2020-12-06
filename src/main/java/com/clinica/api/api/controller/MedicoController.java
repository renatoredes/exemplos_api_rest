package com.clinica.api.api.controller;

import java.util.List;
import java.util.Optional;

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
		return iMedicoRepository.findAll();
	}

	@GetMapping("/{medicoId}")
	public ResponseEntity<Medico> buscar(@PathVariable Long medicoId) {
		Optional<Medico> medico = iMedicoRepository.findById(medicoId);
		// Verifica se estar presente se sim retorna alguma um medico cadastrado
		if (medico.isPresent()) {
			return ResponseEntity.ok(medico.get());
		}

		return ResponseEntity.notFound().build();
	}
	/*
	 * Busca por nome especifico ou letra que conter dentro do nome.
	 * 
	 * @RequestParam buscar por Query params
	 */
//	@GetMapping("/busca-por-nome")
//	public List<Medico> cozinhasPorNome(@RequestParam("nome") String nome) {
//		return iMedicoRepository.buscarPorNome(nome);
//	}
//	
	/*
	 * faz uma busca pelo nome exato passado no parametro
	 */

	@GetMapping("/por-nome-exato")
	public List<Medico> medicosPorNome(String nome) {
		return iMedicoRepository.findTodosMedicosByNome(nome);
	}

	/*
	 * faz uma busca pelo nome ou letra passado no parametro ou tracho de frase
	 * retorna a consulta com todos os nomes do medico pesquisado com a letra a por exemplo
	 * no postman podemos fazer um GET assim: http://localhost:8080/medicos/por-nome-letra?nome=A
	 */
	
	@GetMapping("/por-nome-letra")
	public List<Medico> buscarQualquerNomeLetra (String nome) {
		return iMedicoRepository.findTodosMedicosByNomeContaining(nome);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Medico adicionar(@RequestBody Medico medico) {
		return medicoService.salvar(medico);
	}

	@PutMapping("/{medicoId}")
	public ResponseEntity<Medico> atualizar(@PathVariable Long medicoId, @RequestBody Medico medico) {
		Optional<Medico> medicoAtual = iMedicoRepository.findById(medicoId);

		if (medicoAtual.isPresent()) {
			BeanUtils.copyProperties(medico, medicoAtual.get(), "id");

			Medico medicoSalvo = medicoService.salvar(medicoAtual.get());
			return ResponseEntity.ok(medicoSalvo);
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
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
