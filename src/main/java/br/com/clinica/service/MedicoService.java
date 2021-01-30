package br.com.clinica.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinica.domain.exeption.EntityNotFoundException;
import br.com.clinica.domain.model.Medico;
import br.com.clinica.dto.request.MedicoDTO;
import br.com.clinica.dto.response.MessageResponseDTO;
import br.com.clinica.mapper.MedicoMapper;
import br.com.clinica.repository.MedicoRepository;
import lombok.AllArgsConstructor;

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
	 
	 
	public MedicoDTO findById(Long id) throws EntityNotFoundException {
		Medico medico = vericaIfExiste(id);
		return medicoMapper.toDTO(medico);
	}


	public MessageResponseDTO updateById(Long id, @Valid MedicoDTO medicoDTO) throws EntityNotFoundException {
		vericaIfExiste(id);
		Medico medicoToUpdate = medicoMapper.toModel(medicoDTO);
	
		Medico updateMedico = medicoRepository.save(medicoToUpdate);
		return createMessageResponse(updateMedico.getId(), "Updated person with ID ");
		
	}

	private Medico vericaIfExiste(Long id) throws EntityNotFoundException {
		return medicoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(id));
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

	public void delete(Long id) throws EntityNotFoundException{
		vericaIfExiste(id);
		medicoRepository.deleteById(id);
	}
	
}
