package ru.digitalleague.taxi_company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.mapper.DriverGradeMapper;
import ru.digitalleague.taxi_company.service.DriverGradeService;
import ru.digitalleague.taxi_company.service.TaxiDriverInfoService;

@Service
public class DriverGradeServiceImpl implements DriverGradeService {

    @Autowired
    private DriverGradeMapper driverGradeMapper;



    @Override
    public int getDriverGradeSumById(Long driverId) {
        return driverGradeMapper.getDriverGradeSumById(driverId);
    }

    @Override
    public int getDriverTripSumById(Long driverId) {
        return driverGradeMapper.getDriverTripSumById(driverId);
    }

    @Override
    public void updateSumTrip(Long driverId) {
        driverGradeMapper.updateSumTrip(driverId);
    }

    @Override
    public void updateGrade(Long driverId, int grade) {
        driverGradeMapper.updateGrade(driverId, grade);
        updateSumTrip(driverId);
    }
}

