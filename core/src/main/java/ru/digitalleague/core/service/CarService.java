package ru.digitalleague.core.service;

import ru.digitalleague.core.model.Car;

public interface CarService {

    Car getById(Long carId);

    void insert(Car car);

    void delete(Long carId);

    void update(Long carId);

}
