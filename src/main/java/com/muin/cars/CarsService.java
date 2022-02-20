package com.muin.cars;

import java.util.List;

public interface CarsService {
	public abstract List<Car> getAllCars();
	public abstract Car getCar(int id);
}
