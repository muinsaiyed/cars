package com.muin.cars;

import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(CarsController.class)
public class CarsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private CarsServiceImpl carsServiceImpl;
	

	@Test
	public void testGetCars() throws Exception {
		Mockito.when(carsServiceImpl.getAllCars()).thenReturn(setupCars());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cars").accept(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String jsonValue = result.getResponse().getContentAsString();
		
		List<Car> returnedCars = mapper.readValue(jsonValue, new TypeReference<List<Car>>(){});

		Assert.assertEquals("the values are not equal", "honda1",returnedCars.get(0).make);
		Assert.assertEquals("the values are not equal", "honda2",returnedCars.get(1).make);
		Assert.assertEquals("the values are not equal", "honda3",returnedCars.get(2).make);
		
	}

	@Test
	public void testGetCarsById() throws Exception {
		Mockito.when(carsServiceImpl.getCar(anyInt())).thenReturn(setupCar());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cars/1").accept(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String jsonValue = result.getResponse().getContentAsString();
		System.out.println("_____________");
		System.out.println(jsonValue);
		System.out.println("_____________");

		Car returnedCar = mapper.readValue(jsonValue, new TypeReference<Car>(){});



		Assert.assertEquals("the values are not equal", "accordtest1",returnedCar.model);
	}
	
	@Test
	public void testGetCarsByBadId() throws Exception {
		Mockito.when(carsServiceImpl.getCar(anyInt())).thenReturn(null);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cars/3").accept(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String jsonValue = result.getResponse().getContentAsString();
		System.out.println("_____________");
		System.out.println(jsonValue);
		System.out.println("_____________");

		Car returnedCar = mapper.readValue(jsonValue, new TypeReference<Car>(){});



		Assert.assertNull(returnedCar);
	}
	
	private List<Car> setupCars() {
		List<Car> carList = new ArrayList<Car>();
		Car car1 = new Car();
		car1.id = 1;
		car1.make = "honda1";
		car1.model = "accordtest1";
		car1.carPackage = "base1";
		car1.color = "black";
		car1.year = 2007;
		car1.category = "sedan";
		car1.mileage = 120000;
		car1.price = 5000;
		carList.add(car1);
		
		Car car2 = new Car();
		car2.id = 1;
		car2.make = "honda2";
		car2.model = "accordtest2";
		car2.carPackage = "base2";
		car2.color = "black";
		car2.year = 2007;
		car2.category = "sedan";
		car2.mileage = 120000;
		car2.price = 5000;
		carList.add(car2);

		Car car3 = new Car();
		car3.id = 1;
		car3.make = "honda3";
		car3.model = "accordtest3";
		car3.carPackage = "base3";
		car3.color = "black";
		car3.year = 2007;
		car3.category = "sedan";
		car3.mileage = 120000;
		car3.price = 5000;
		carList.add(car3);
		
		return carList;
	}

	private Car setupCar() {
		Car car = new Car();
		car.id = 1;
		car.make = "honda";
		car.model = "accordtest1";
		car.carPackage = "base1";
		car.color = "black";
		car.year = 2007;
		car.category = "sedan";
		car.mileage = 120000;
		car.price = 5000;

		return car;
	}
}
