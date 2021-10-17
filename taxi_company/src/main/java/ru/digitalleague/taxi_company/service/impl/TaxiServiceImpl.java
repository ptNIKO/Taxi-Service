package ru.digitalleague.taxi_company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.model.OrderModel;
import ru.digitalleague.taxi_company.service.TaxiService;

@Service
public class TaxiServiceImpl implements TaxiService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void saveOrder(OrderModel order) {
        orderMapper.saveOrder(order);
    }

}
