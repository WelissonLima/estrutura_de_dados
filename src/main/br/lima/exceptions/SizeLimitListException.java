package main.br.lima.exceptions;

public class SizeLimitListException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SizeLimitListException(final String message) {
		super(message);
	}
}
