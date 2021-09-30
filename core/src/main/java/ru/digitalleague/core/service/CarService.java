package ru.digitalleague.core.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.digitalleague.core.model.Car;

public interface CarService {

    Car getById(long carId);

    void insert(Car car);

    void delete(long carId);

    void update(long carId);
}
