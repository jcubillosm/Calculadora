package com.calculadora.calculadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.calculadora.services.CalculadoraService;

import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	@Autowired
	CalculadoraService calculadoraService;
	private TracerImpl tracer = new TracerImpl();

	@Operation(summary = "Calculadora")
	@GetMapping("/{operation}/{firstOperator}/{secondOperator}")
	public ResponseEntity<?>  operationControl(@Parameter(description = "Operación seleccionada") @PathVariable String operation,
			@Parameter(description = "Primer operador") @PathVariable String firstOperator,
			@Parameter(description = "Segundo operador") @PathVariable String secondOperator) {
		log.info("CalculadoraController: operationControl");
		Double result = calculadoraService.operationControl(operation, firstOperator, secondOperator);
		
		tracer.trace(result);
		return ResponseEntity.ok(result);
	}

}
