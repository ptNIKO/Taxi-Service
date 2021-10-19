package ru.digitalleague.taxi_company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.mapper.TaxiDriverInfoMapper;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.service.DriverGradeService;
import ru.digitalleague.taxi_company.service.TaxiDriverInfoService;

@Service
public class TaxiDriverInfoServiceImpl implements TaxiDriverInfoService {

    @Autowired
    private TaxiDriverInfoMapper taxiDriverInfoMapper;

    @Autowired
    private DriverGradeService driverGradeService;

    @Override
    public TaxiDriverInfoModel findDriver(OrderDetails orderDetails) {
        System.out.println("Ваш водитель найден ");
        return taxiDriverInfoMapper.findDriver(orderDetails);
    }

    @Override
    public void setDriverActiveStatus(Long driverId) {
        if (taxiDriverInfoMapper.getActiveStatus(driverId)){
            taxiDriverInfoMapper.setDriverActiveStatus(driverId, false);
        } else {
            taxiDriverInfoMapper.setDriverActiveStatus(driverId, true);
        }
    }

    @Override
    public Long getMinuteCost(Long driverId) {
        return taxiDriverInfoMapper.getMinuteCost(driverId);
    }

    @Override
    public void updateRating(Long driverId, double rating) {
        double avgRating;
        int gradeSum;
        int tripSum;
        if (driverGradeService.getDriverTripSumById(driverId) != 0) {
            gradeSum = driverGradeService.getDriverGradeSumById(driverId);
            tripSum = driverGradeService.getDriverTripSumById(driverId);
            avgRating = (double) gradeSum / (double) tripSum; // считаем средний рейтинг водителя
            taxiDriverInfoMapper.updateRating(driverId, avgRating);
        }
        // else add sum and grade
    }
}
