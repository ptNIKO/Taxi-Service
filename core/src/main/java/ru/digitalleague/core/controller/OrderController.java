package ru.digitalleague.core.controller;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.core.model.OrderDetails;

@RestController
public class OrderController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/order")
    public void addNewOrderDetails(@RequestBody OrderDetails orderDetails) {
        template.convertAndSend("order", orderDetails.toString());
    }
}
