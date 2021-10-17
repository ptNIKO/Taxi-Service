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
import ru.digitalleague.taxi_company.service.TaxiService;

@RestController
public class TaxiController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private OrderMapper orderMapper;


    @PostMapping("/start-trip")
    public ResponseEntity<String> startTrip(@RequestBody OrderModel order) {
        System.out.println("Trip is start");

        OrderModel orderById = orderMapper.getOrderById(order.getId());

        orderMapper.updateStartOrderTime(orderById);

        return ResponseEntity.ok("Поездка началась");
    }

    /**
     * Метод получает инфо о завершении поездки.
     * @param order
     * */
    @PostMapping("/finish-trip")
    public ResponseEntity<String> finishTrip(@RequestBody OrderModel order) {
        System.out.println("Trip is finished");

        OrderModel orderById = orderMapper.getOrderById(order.getId());

        orderMapper.updateFinishOrderTime(orderById);

        return ResponseEntity.ok("Услуга оказана");
    }
}