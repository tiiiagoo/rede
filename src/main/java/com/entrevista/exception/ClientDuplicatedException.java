package com.entrevista.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Cliente já consta na base de dados")
public class ClientDuplicatedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
}
