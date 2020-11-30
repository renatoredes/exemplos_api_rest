package com.clinica.api.domain.exception;

public class RecursoNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
}
