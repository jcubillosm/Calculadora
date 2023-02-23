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
	
	public Double sumOperation(String firstOperator, String secondOperation){
		log.info("calculadoraService: sumOperation");
		if (!calculadoraUtil.isNumeric(firstOperator) || !calculadoraUtil.isNumeric(secondOperation)) {
			throw new mathOperationException("Please set a numeric value");
		}
		
		return calculadoraUtil.convertToDouble(firstOperator) + calculadoraUtil.convertToDouble(secondOperation);
		
	}

}
