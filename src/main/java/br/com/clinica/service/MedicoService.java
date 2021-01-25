package br.com.clinica.service;

import org.springframework.stereotype.Service;


import br.com.clinica.domain.model.Medico;
import br.com.clinica.dto.request.MedicoDTO;
import br.com.clinica.dto.response.MessageResponseDTO;
import br.com.clinica.mapper.MedicoMapper;
import br.com.clinica.repository.MedicoRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MedicoService {

	private MedicoRepository medicoRepository;
	
	 private final MedicoMapper medicoMapper = MedicoMapper.INSTANCE;

	 public MessageResponseDTO createMedico(MedicoDTO medicoDTO) {
		 Medico medicoToSave = medicoMapper.toModel(medicoDTO);
		 
		 Medico saveMedico = medicoRepository.save(medicoToSave);
		return createMessageResponse(saveMedico.getId(), "Created medico with ID");

	}

	 public List<MedicoDTO> listAll() {
		 List<Medico> listarMedicos = medicoRepository.findAll();
		 return listarMedicos.stream()
	                .map(medicoMapper::toDTO)
	                .collect(Collectors.toList());
	 }
	 
	 private MessageResponseDTO createMessageResponse(Long id, String message) {
	        return MessageResponseDTO
	                .builder()
	                .message(message + id)
	                .build();
	    }

}
