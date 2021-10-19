package ru.digitalleague.taxi_company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.mapper.CityMapper;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.OrderModel;
import ru.digitalleague.taxi_company.service.OrderService;
import ru.digitalleague.taxi_company.service.TaxiDriverInfoService;
import ru.digitalleague.taxi_company.utils.OrderConvert;

import java.time.OffsetDateTime;

/**
 * Сервис обработки заказов.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private TaxiDriverInfoService taxiDriverInfoService;

    @Autowired
    private CityMapper cityMapper;


    @Override
    public void setOrder(OrderModel order) {
        orderMapper.setOrder(order);
    }


    @Override
    public OrderModel getOrderById(Long orderId) {
        return orderMapper.getOrderById(orderId);
    }

    @Override
    public Long getDriverIdByOrderId(Long orderId) {
        return orderMapper.getDriverIdByOrderId(orderId);
    }

    @Override
    public void updateStartOrderTime(OrderModel order) {
        orderMapper.updateStartOrderTime(order);
    }

    @Override
    public void updateFinishOrderTime(OrderModel order) {
        orderMapper.updateFinishOrderTime(order);
    }

    @Override
    public void proceedOrder(OrderDetails orderDetails) {

        if (orderDetails == null) return;

        String city = orderDetails.getCity();
        Long cityId = cityMapper.findCityIdByName(city);
        orderDetails.setCityId(cityId);

        TaxiDriverInfoModel taxiDriver = taxiDriverInfoService.findDriver(orderDetails);

        OrderModel orderModel = OrderConvert.convertOrderDetailsIntoOrder(orderDetails, taxiDriver);
        setOrder(orderModel);

        System.out.println("Водитель найден и заказ сохранен: " + taxiDriver.getDriverId());
    }

    @Override
    public OffsetDateTime getStartOrderTime(Long orderId) {
        return orderMapper.getStartOrderTime(orderId);
    }

    @Override
    public OffsetDateTime getFinishOrderTime(Long orderId) {
        return orderMapper.getFinishOrderTime(orderId);
    }

    @Override
    public void setGrade(Long orderId, double grade) {
        orderMapper.setGrade(orderId, grade);

    }

}
