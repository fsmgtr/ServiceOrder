package br.com.os.exception;

public class DetaIntegratyViolantionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DetaIntegratyViolantionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DetaIntegratyViolantionException(String message) {
		super(message);
	}

}
