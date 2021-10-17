package ru.digitalleague.taxi_company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.mapper.TaxiDriverInfoMapper;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.service.TaxiDriverInfoService;

@Service
public class TaxiDriverInfoServiceImpl implements TaxiDriverInfoService {

    @Autowired
    private TaxiDriverInfoMapper taxiDriverInfoMapper;

    @Override
    public TaxiDriverInfoModel findDriver(OrderDetails orderDetails) {
        System.out.println("Ваш водитель найден ");
        return taxiDriverInfoMapper.findDriver(orderDetails);
    }

    @Override
    public void setDriverActiveStatus(Long driver_id) {
        if (taxiDriverInfoMapper.getActiveStatus(driver_id)){
            taxiDriverInfoMapper.setDriverActiveStatus(driver_id, false);
        } else {
            taxiDriverInfoMapper.setDriverActiveStatus(driver_id, true);
        }
    }
}
