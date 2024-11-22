package com.example.demo.animalAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalAPI.service.AnimalService;
import com.example.demo.sampleAPI.data.Animals;
@RequestMapping("")
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
	
	@GetMapping("animal-detail")//animal.idを取得
	public String getPets(@RequestParam("animal.id")int id,Model model) throws IOException {
		 animalService.Animaldetail(id);//animaldetailメソッドでhtmlで選択された動物のid情報リポジトリに持っていく。
		 
		 List<Animals> result = animalService.getAnimals2(id);
		//getAnimals2メソッドでidと同じ動物のデータを持ってきたのでresultに返す。
				model.addAttribute("animalList",result);
		return "animal-detail.html";
	}
}