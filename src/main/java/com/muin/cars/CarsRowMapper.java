package com.muin.cars;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CarsRowMapper implements RowMapper<Car> {
   
	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car car = new Car();
		car.id = rs.getInt("idcars");
		car.make = rs.getString("make");
		car.model = rs.getString("model");
		car.carPackage = rs.getString("carpackage");
		car.color = rs.getString("color");
		car.year = rs.getInt("year");
		car.category = rs.getString("category");
		car.mileage = rs.getInt("mileage");
		car.price = rs.getInt("price");
        return car;
	}
}
