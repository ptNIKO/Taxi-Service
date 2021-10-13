package ru.digitalleague.taxi_company.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.service.TaxiService;

@RestController
public class TaxiController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private TaxiService taxiService;

    @PostMapping("/trip-start")
    public ResponseEntity<String> startTrip(@RequestBody OrderDetails orderDetails) {
        taxiService.addStartTimeTip(orderDetails.getOrderId());
        return ResponseEntity.ok("Поездка началась");
    }

    /**
     * Метод получает инфо о завершении поездки.
     * @param orderDetails
     * */
    @PostMapping("/trip-complete")
    public ResponseEntity<String> completeTrip(@RequestBody OrderDetails orderDetails) {
        System.out.println("Trip is finished");
        taxiService.addEndTimeTip(orderDetails.getOrderId());
        amqpTemplate.convertAndSend("trip-result", orderDetails);
        return ResponseEntity.ok("Услуга оказана");
    }
}