package br.com.clinica.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaudoMedicoDTO {

	private Long id;
	
	private String descricaoLaudoMedico;

}
