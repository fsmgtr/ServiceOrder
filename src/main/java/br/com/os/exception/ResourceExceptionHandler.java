package br.com.os.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException e) {
		StandartError standartError = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);

	}

	@ExceptionHandler(DetaIntegratyViolantionException.class)
	public ResponseEntity<StandartError> objectNotFoundException(DetaIntegratyViolantionException e) {
		StandartError standartError = new StandartError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);

	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> objectNotFoundException(MethodArgumentNotValidException e) {
		 ValidationError error = new ValidationError(System.currentTimeMillis(), 
				 HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos!");
		 
		 for(FieldError x : e.getBindingResult().getFieldErrors()) {
			 error.addErrors(x.getField(), x.getDefaultMessage());
		 }
 

		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	

}
