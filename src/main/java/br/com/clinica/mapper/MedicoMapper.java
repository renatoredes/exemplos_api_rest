package br.com.clinica.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.clinica.domain.model.Medico;
import br.com.clinica.dto.request.MedicoDTO;

/***
 * 
 * @author Renato
 *	Interface responsável por : realizar uma conversão de um objeto de uma
 *  entidade para um DTO e de um DTO para uma entidade
 */
@Mapper
public interface MedicoMapper {

	MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

	Medico toModel(MedicoDTO medicoDTO);
	
	MedicoDTO toDTO(Medico medico);
}
