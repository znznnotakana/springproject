package com.example.demo.animalAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalAPI.data.Animals;
import com.example.demo.animalAPI.service.AnimalService;

@Controller
public class AnimalController {

	private final AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}
	
	@GetMapping("animal-search")
	public String search(Model model)throws IOException{
		List<Animals> animalsList = animalService.getAnimals();
		model.addAttribute("animalsList",animalsList);
		
		return "animal-search.html";
	}
	
	@GetMapping("animal-detail")
	public String getPets(@RequestParam("animal.id")int id,Model model) throws IOException {
		Animals[] result = animalService.Animaldetail(id);
		
				model.addAttribute("animalList",result);
		return "animal-detail.html";
	}
}