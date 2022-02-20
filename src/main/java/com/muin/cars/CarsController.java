package com.muin.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController class CarsController {
	
	@Autowired
	CarsServiceImpl carsService;
	
	@Autowired
	ObjectMapper mapper;
	
	
	@GetMapping("/status")
	public String getStatus() {
		return "We are up and running";
	}
	
	
	@GetMapping("/cars")
	public String getCars() throws JsonProcessingException {
		
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		// Convert object to JSON string
		String allCars = mapper.writeValueAsString(carsService.getAllCars());
		
		return allCars;
	}
	
	@GetMapping("/cars/{id}")
	public String getCarsById(@PathVariable int id) throws JsonProcessingException {
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		// Convert object to JSON string
		String car = mapper.writeValueAsString(carsService.getCar(id));
		
		return car;
	}
	
	


}
