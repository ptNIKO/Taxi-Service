package ru.digitalleague.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.digitalleague.core.mapper.CarMapper;
import ru.digitalleague.core.model.Car;
import ru.digitalleague.core.service.CarService;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarMapper carMapper;

    @Override
    public Car getById(Long carId) {
        return carMapper.getById(carId);
    }

    @Override
    public void insert(Car car) {
        carMapper.insert(car);
    }

    @Override
    public void delete(Long carId) {
        carMapper.delete(carId);
    }

    @Override
    public void update(Long carId) {
        carMapper.update(carId);
    }

}
