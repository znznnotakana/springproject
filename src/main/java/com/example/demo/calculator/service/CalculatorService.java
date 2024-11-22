package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService{
	public String calculator(int num1,int num2,String mark) {
		int result=0; 
		String Mark = mark;
		String resultString;
		try {
			switch(Mark) {
			case "+":
				result=num1+num2;
				break;
			case "-":
				result=num1-num2;
				break;
			case "×":
				result=num1*num2;
				break;
			case"÷":
				result=num1/num2;
				break;
			default:
				break;
		}		
		resultString=String.valueOf(result);
		return resultString;
		}
		catch(ArithmeticException e) {
			resultString="ゼロ除算は出来ません"+e.getMessage();
			return resultString;
		}
	}
}