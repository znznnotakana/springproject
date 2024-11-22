package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController{
	private final CalculatorService calculatorService;
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	@GetMapping("calculator1")
	public String cal() {
		return"calculator.html";
	}
	@GetMapping("calculator")
	public String calculatorUser(@RequestParam("num1")int num1,@RequestParam("num2")int num2,@RequestParam("mark")String mark, Model model) {
		String result;
		result = calculatorService.calculator(num1, num2,mark);
		model.addAttribute("result",result);
		return "calculator.html";
	}
}
 