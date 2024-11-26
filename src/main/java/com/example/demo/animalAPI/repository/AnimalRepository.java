package com.example.demo.animalAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.animalAPI.data.Animals;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalRepository {
	public Animals[] getAnimals() throws IOException{
		
		String url="https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";
		RestTemplate rest =new RestTemplate();
		ResponseEntity<String>response = rest.getForEntity(url, String.class);
		String json =response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Animals[] animalList = mapper.readValue(json,Animals[].class);
		return animalList;
	}
	public Animals[] getAnimals2(int id) throws IOException{
		//urlをidに変更し、idと紐づいたデータのみ取得させる。animalList2にデータを返す。
		String strId= String.valueOf(id);
		String url="https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI?id="+strId;
		RestTemplate rest =new RestTemplate();
		ResponseEntity<String>response = rest.getForEntity(url, String.class);
		String json =response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Animals[] animalList2 = mapper.readValue(json,Animals[].class);
		return animalList2;
	}
}
