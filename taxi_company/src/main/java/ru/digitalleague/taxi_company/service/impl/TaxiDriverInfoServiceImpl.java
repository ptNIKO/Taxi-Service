package ru.digitalleague.taxi_company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.mapper.TaxiDriverInfoMapper;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.service.TaxiDriverInfoService;

@Service
public class TaxiDriverInfoServiceImpl implements TaxiDriverInfoService {

    @Autowired
    private TaxiDriverInfoMapper taxiDriverInfoMapper;

    @Override
    public TaxiDriverInfoModel getDriver(OrderDetails orderDetails) {
        System.out.println("Ваш водитель найден ");
        return taxiDriverInfoMapper.getDriver(orderDetails);
    }

    @Override
    public void setDriverActiveStatus(Long driver_id, boolean activeStatus) {
        taxiDriverInfoMapper.setDriverActiveStatus(driver_id, activeStatus);
    }
}
