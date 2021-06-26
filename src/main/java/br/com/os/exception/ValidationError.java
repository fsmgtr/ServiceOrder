package br.com.os.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError {

	private static final long serialVersionUID = 1L;

	 
	private List<FieldMessagerss> errors = new ArrayList<>();

	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer satus, String error) {
		super(timestamp, satus, error);
	}


	public List<FieldMessagerss> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessagerss(fieldName, message));

	}

}
