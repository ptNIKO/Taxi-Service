package ru.digitalleague.taxi_company.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.OrderModel;
import ru.digitalleague.taxi_company.service.TaxiDriverInfoService;
import ru.digitalleague.taxi_company.service.TaxiService;

@RestController
public class TaxiController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    TaxiDriverInfoService taxiDriverInfoService;

    /**
     * Метод получает инфо о начале поездки.
     * @param order
     * */
    @PostMapping("/start-trip")
    public ResponseEntity<String> startTrip(@RequestBody OrderModel order) {
        OrderModel orderById = orderMapper.getOrderById(order.getId());
        orderMapper.updateStartOrderTime(orderById);

        orderMapper.getDriverIdByOrderId(order.getId());
        taxiDriverInfoService.setDriverActiveStatus(orderById.getDriverId());


        System.out.println("Trip is start");
        return ResponseEntity.ok("Поездка началась");
    }

    /**
     * Метод получает инфо о завершении поездки.
     * @param order
     * */
    @PostMapping("/finish-trip")
    public ResponseEntity<String> finishTrip(@RequestBody OrderModel order) {
        OrderModel orderById = orderMapper.getOrderById( order.getId());
        orderMapper.updateFinishOrderTime(orderById);

        orderMapper.getDriverIdByOrderId(order.getId());
        taxiDriverInfoService.setDriverActiveStatus(orderById.getDriverId());

        System.out.println("Trip is finished");
        return ResponseEntity.ok("Услуга оказана");
    }
}