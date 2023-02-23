package com.calculadora.calculadora.services;

public interface CalculadoraService {
	public Double operationControl(String operation, String firstOperator, String secondOperation);
	public void checkOperators(String firstOperator, String secondOperation);
	public Double sumOperation(String firstOperator, String secondOperation);

}
