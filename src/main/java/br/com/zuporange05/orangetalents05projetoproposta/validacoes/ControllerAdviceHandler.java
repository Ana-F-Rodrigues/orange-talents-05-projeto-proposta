package br.com.zuporange05.orangetalents05projetoproposta.validacoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDto> handle(MethodArgumentNotValidException methodArgumentNotValidException) {
		Collection<String> mensagens = new ArrayList<>();
		BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		fieldErrors.forEach(fieldError -> {
			String message = String.format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
			mensagens.add(message);
		});

		ErrorDto errorDto = new ErrorDto(mensagens);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
	}

	@ExceptionHandler(ApiErrorException.class)
	public ResponseEntity<ErrorDto> handleApiErrorException(ApiErrorException apiErrorException) {
		Collection<String> mensagens = new ArrayList<>();
		mensagens.add(apiErrorException.getReason());

		ErrorDto errorDto = new ErrorDto(mensagens);
		return ResponseEntity.status(apiErrorException.getHttpStatus()).body(errorDto);
	}

}
