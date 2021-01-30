package br.com.clinica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.clinica.dto.request.MedicoDTO;
import br.com.clinica.dto.response.MessageResponseDTO;
import br.com.clinica.service.MedicoService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/medico")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MedicoController {

	private MedicoService medicoService;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createMedico(@RequestBody @Valid MedicoDTO medicoDTO) {
        return medicoService.createMedico(medicoDTO);
    }

    @GetMapping
    public List<MedicoDTO> listAll() {
        return medicoService.listAll();
    }
}
