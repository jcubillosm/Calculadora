package com.calculadora.calculadora.utils;

public class CalculadoraUtil {
	
	public Double convertToDouble(String str) {
		Double nullNumber = 0D;
		
		if(null != str){
			String newNumber = str.replaceAll(",", ".");
			return (isNumeric(newNumber)) ? Double.parseDouble(newNumber) : nullNumber;
		}		
		return nullNumber;
	}

	public boolean isNumeric(String number) {
		
		if(null != number){
			String newNumber = number.replaceAll(",", ".");
			return newNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
		}
		return false;		
	}

}
