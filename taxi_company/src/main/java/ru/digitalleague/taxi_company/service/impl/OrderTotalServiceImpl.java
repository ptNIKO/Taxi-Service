package ru.digitalleague.taxi_company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digitalleague.taxi_company.mapper.OrderTotalMapper;
import ru.digitalleague.taxi_company.service.OrderService;
import ru.digitalleague.taxi_company.service.OrderTotalService;
import ru.digitalleague.taxi_company.service.TaxiDriverInfoService;

import java.time.Duration;
import java.time.OffsetDateTime;

@Service
public class OrderTotalServiceImpl implements OrderTotalService {

    @Autowired
    private OrderTotalMapper orderTotalMapper;

    @Autowired
    private TaxiDriverInfoService taxiDriverInfoService;

    @Autowired
    private OrderService orderService;

    @Override
    public Long countPrice(Long orderId) {
        Long cost;
        OffsetDateTime start_trip = orderService.getStartOrderTime(orderId);
        OffsetDateTime end_trip = orderService.getFinishOrderTime(orderId);
        Duration d = Duration.between( start_trip , end_trip.plusMinutes(2));
        cost = (d.getSeconds() / 60) * taxiDriverInfoService.getMinuteCost(orderService.getDriverIdByOrderId(orderId));
        addOrderPrice(orderId, cost);
        return cost;
    }

    @Override
    public void addOrderPrice(Long orderId, Long cost) {
        orderTotalMapper.addOrderPrice(orderId, cost);
    }
}