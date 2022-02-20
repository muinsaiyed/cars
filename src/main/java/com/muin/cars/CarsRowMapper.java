package com.muin.cars;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CarsRowMapper implements RowMapper<Car> {
   
	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car car = new Car();
		car.id = rs.getInt("idcars");
		car.make = rs.getString("Make");
		car.model = rs.getString("Model");
		car.carPackage = rs.getString("CarPackage");
		car.color = rs.getString("Color");
		car.year = rs.getInt("Year");
		car.category = rs.getString("Category");
		car.mileage = rs.getInt("Mileage");
		car.price = rs.getInt("Price");
        return car;
	}
}
