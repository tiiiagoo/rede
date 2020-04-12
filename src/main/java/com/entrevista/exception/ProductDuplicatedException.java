package com.entrevista.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Produto com o codigo informado já consta na base de dados")
public class ProductDuplicatedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
}
