package com.calculadora.calculadora.exceptions;

public class mathOperationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public mathOperationException (String message) {
		super(message);
	}

}
