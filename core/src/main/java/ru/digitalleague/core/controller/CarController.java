package ru.digitalleague.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.core.model.Car;
import ru.digitalleague.core.service.CarService;
import ru.digitalleague.core.service.impl.CarServiceImpl;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/get/{carId}")
    public Car getCar(@PathVariable long carId) {
        Car car = carService.getById(carId);
        return car;
    }

    @PostMapping("/add")
    public void addCar(@RequestBody Car car) {
        carService.insert(car);
        System.out.println("Car is add");
    }

    @DeleteMapping("/delete/{carId}")
    public void deleteCar(@PathVariable long carId) {
        carService.delete(carId);
        System.out.println("Car is delete");
    }

    @PutMapping("/update/{carId}")
    public void updateCar(@PathVariable long carId) {
        carService.update(carId);
        System.out.println("Car is update");
    }
}
