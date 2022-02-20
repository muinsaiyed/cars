package com.muin.cars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarsServiceImpl implements CarsService{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Car> getAllCars() {
		
		CarsRowMapper mapper = new CarsRowMapper();
		String sql = "SELECT * FROM dealership.cars";
		
		List<Car> cars = jdbcTemplate.query(sql, mapper);
         
        return cars;
		
	}

	@Override
	public Car getCar(int id) {
		CarsRowMapper mapper = new CarsRowMapper();
		String sql = "SELECT * FROM dealership.cars WHERE idcars=" + id;
		
		Car car = jdbcTemplate.queryForObject(sql, mapper);
         
        return car;
		
	}
	
}
