package com.mechanicproject.service;

import com.mechanicproject.entity.Car;
import com.mechanicproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private CarRepository carRepository;

    public void saveCarsList(List<Car> carList){
        carRepository.save(carList);
    }
}
