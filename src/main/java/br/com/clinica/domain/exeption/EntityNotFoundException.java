package br.com.clinica.domain.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = -4690299859564422782L;

	public EntityNotFoundException(Long id) {
		super("Medico not found with ID " + id);
	}

}
