package com.calculadora.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculadora.calculadora.exceptions.mathOperationException;
import com.calculadora.calculadora.services.impl.calculadoraServiceImpl;
import com.calculadora.calculadora.utils.CalculadoraUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CalculadoraServiceTest {
	@Mock
	calculadoraServiceImpl calculadoraServiceImpl;

	CalculadoraUtil calculadoraUtil = new CalculadoraUtil();

	@Test
	public void sumOperationTest() {
		String firstOperator = "900";
		String secondOperator = "100";
		String operation = "sum";
		double result = calculadoraUtil.convertToDouble(firstOperator)
				+ calculadoraUtil.convertToDouble(secondOperator);
		when(calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator)).thenReturn(result);
		assertEquals(1000, result);
	}

	@Test
	public void subOperationTest() {
		String firstOperator = "900";
		String secondOperator = "100";
		String operation = "sub";
		double result = calculadoraUtil.convertToDouble(firstOperator)
				- calculadoraUtil.convertToDouble(secondOperator);
		when(calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator)).thenReturn(result);
		assertEquals(800, result);
	}

	@Test
	public void multOperationTest() {
		String firstOperator = "748";
		String secondOperator = "3";
		String operation = "mult";
		double result = calculadoraUtil.convertToDouble(firstOperator)
				* calculadoraUtil.convertToDouble(secondOperator);
		when(calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator)).thenReturn(result);
		assertEquals(2244, result);
	}

	@Test
	public void divOperationTest() {
		String firstOperator = "748";
		String secondOperator = "3";
		String operation = "div";
		double result = calculadoraUtil.convertToDouble(firstOperator)
				/ calculadoraUtil.convertToDouble(secondOperator);
		when(calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator)).thenReturn(result);
		assertEquals(249.33333333333334, result);
	}

	@Test
	void divExceptionTest() throws Exception {
		String firstOperator = "748";
		String secondOperator = "0";
		String operation = "div";
		when(calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator))
				.thenThrow(new mathOperationException("INVALID_OPERATOR"));

		Exception result = assertThrows(mathOperationException.class,
				() -> calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator));
		assertEquals(mathOperationException.class, result.getClass());
	}

	@Test
	void numberOperatorExceptionTest() throws Exception {
		String firstOperator = "AA";
		String secondOperator = "23";
		String operation = "sum";

		when(calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator))
				.thenThrow(new mathOperationException("NOT_NUMERIC_OPERATOR"));
		Exception result = assertThrows(mathOperationException.class,
				() -> calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator));
		assertEquals(mathOperationException.class, result.getClass());
	}

	@Test
	void notValidOperationExceptionTest() throws Exception {
		String firstOperator = "23";
		String secondOperator = "10";
		String operation = "ham";

		when(calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator))
				.thenThrow(new mathOperationException("NOT_VALID_OPERATION"));
		Exception result = assertThrows(mathOperationException.class,
				() -> calculadoraServiceImpl.operationControl(operation, firstOperator, secondOperator));
		assertEquals(mathOperationException.class, result.getClass());
	}
}
