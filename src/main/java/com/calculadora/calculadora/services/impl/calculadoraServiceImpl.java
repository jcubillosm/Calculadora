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
			return sumOperation(firstOperator, secondOperation);
			
		/*case "sub":

			return null;
		case "div":

			break;
		case "mult":

			return null;*/

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

	public Double sumOperation(String firstOperator, String secondOperation) {
		return calculadoraUtil.convertToDouble(firstOperator) + calculadoraUtil.convertToDouble(secondOperation);
	}

}
