package com.binary.carShow.service;

import com.binary.carShow.entity.Car;
import com.binary.carShow.exception.ResourceNotFoundException;
import com.binary.carShow.repository.CarRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
//           Optional<Car> optionalCar =  carRepository.findById(id);
//
//           if(optionalCar.isPresent()) {
//               return optionalCar.get();
//           } else  {
//               throw new ResourceNotFoundException("Car with id " + id + " not found");
//           }

      return carRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Car with id"+ id+ " not found."));


    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {

        carRepository.deleteById(id);

    }

    @Override
    public Car updateCarById(Long id, Car car) {

        Car existingCar =  getCarById(id);
        existingCar.setMake(car.getMake());
        existingCar.setModel(car.getModel());
        existingCar.setColor(car.getColor());
        existingCar.setRegisterNumber(car.getRegisterNumber());
        existingCar.setYear(car.getYear());
        existingCar.setPrice(car.getPrice());
        carRepository.save(existingCar);
        return existingCar;


    }

    @Override
    public List<Car> getCarByMake(String make) {
        return carRepository.getAllCarByMake(make);
    }


}
