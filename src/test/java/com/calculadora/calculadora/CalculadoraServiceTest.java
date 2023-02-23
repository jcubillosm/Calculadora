package com.calculadora.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculadora.calculadora.services.impl.calculadoraServiceImpl;
import com.calculadora.calculadora.utils.CalculadoraUtil;

@SpringBootTest
public class CalculadoraServiceTest {
	@Mock
	calculadoraServiceImpl calculadoraServiceImpl;
	
	CalculadoraUtil calculadoraUtil = new CalculadoraUtil();
	@Test
	public void sumOperationTest() {
		String firstOperator = "900";
		String secondOperator = "100";
		double result = calculadoraUtil.convertToDouble(firstOperator) + calculadoraUtil.convertToDouble(secondOperator);
		when(calculadoraServiceImpl.sumOperation(firstOperator, secondOperator)).thenReturn(result);
		assertEquals(1000, result);
	}
}
