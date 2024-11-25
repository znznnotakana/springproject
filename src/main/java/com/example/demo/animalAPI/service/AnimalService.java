package com.example.demo.animalAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.animalAPI.data.Animals;
import com.example.demo.animalAPI.repository.AnimalRepository;


@Service
public class AnimalService {

	private final AnimalRepository animalRepository;

	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	public List<Animals> getAnimals() throws IOException {
		Animals[] animalsList = animalRepository.getAnimals();
		return Arrays.asList(animalsList);
	}
	
	
	public  Animals[] Animaldetail(int id) throws IOException{
		Animals animal[]= animalRepository.getAnimals2(id);
		
		return animal;
	}	
	
}