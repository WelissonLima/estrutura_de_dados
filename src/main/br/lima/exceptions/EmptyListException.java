package main.br.lima.exceptions;

public class EmptyListException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmptyListException(final String message) {
		super(message);
	}
}
