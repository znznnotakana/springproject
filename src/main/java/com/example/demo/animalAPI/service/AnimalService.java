package com.example.demo.animalAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.animalAPI.repository.AnimalRepository;
import com.example.demo.sampleAPI.data.Animals;


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
		return animalRepository.getAnimals2(id);
	}	
	
	public List<Animals>getAnimals2(int id)throws IOException{
		//anomalList2にgetAnimals2メソッドでidと紐づいたデータを入れて返す。
		Animals[] animalsList2 = animalRepository.getAnimals2(id);
		return Arrays.asList(animalsList2);
	}
	
}