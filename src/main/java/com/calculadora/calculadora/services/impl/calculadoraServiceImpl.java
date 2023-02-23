package com.calculadora.calculadora.services.impl;

import org.springframework.stereotype.Service;

import com.calculadora.calculadora.exceptions.mathOperationException;
import com.calculadora.calculadora.services.CalculadoraService;
import com.calculadora.calculadora.utils.CalculadoraUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class calculadoraServiceImpl implements CalculadoraService {

	CalculadoraUtil calculadoraUtil = new CalculadoraUtil();

	public Double operationControl(String operation, String firstOperator, String secondOperation) {
		if (null == operation) {
			throw new mathOperationException("Please, set a valid operator");
		}
		checkOperators(firstOperator, secondOperation);

		switch (operation) {
		case "sum":
			return calculadoraUtil.convertToDouble(firstOperator) + calculadoraUtil.convertToDouble(secondOperation);
		case "sub":
			return calculadoraUtil.convertToDouble(firstOperator) - calculadoraUtil.convertToDouble(secondOperation);
		case "div":
			divOperation(calculadoraUtil.convertToDouble(secondOperation));
			return calculadoraUtil.convertToDouble(firstOperator) / calculadoraUtil.convertToDouble(secondOperation);
		case "mult":
			return calculadoraUtil.convertToDouble(firstOperator) * calculadoraUtil.convertToDouble(secondOperation);

		default:
			throw new mathOperationException("Please, set a valid operator [sum, sub, div or mult]");
		}

	}

	public void checkOperators(String firstOperator, String secondOperation) {
		log.info("calculadoraService: checkOperators");
		if (!calculadoraUtil.isNumeric(firstOperator) || !calculadoraUtil.isNumeric(secondOperation)) {
			throw new mathOperationException("Please set a numeric value ");
		}
	}

	public void divOperation(Double secondOperation) {
		log.info("calculadoraService: divOperation");
		if (secondOperation < 0) {
			throw new mathOperationException(
					"Please, check that the second operator is greater than zero to perform the division");
		}
	}

}
