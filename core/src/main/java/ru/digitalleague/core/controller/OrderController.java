package ru.digitalleague.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.core.model.OrderDetails;
import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.core.service.TaxiInfoService;

@RestController
public class OrderController {

    @Autowired
    private TaxiInfoService taxiInfoService;

    private final RabbitTemplate template;
    private final ObjectMapper mapper ;

    public OrderController(ObjectMapper mapper, RabbitTemplate template) {
        this.mapper = mapper;
        this.template = template;
    }

    @PostMapping("/order")
    public void addNewOrderDetails(@RequestBody OrderDetails orderDetails) {
        try {
            template.convertAndSend("order", mapper.writeValueAsString(orderDetails));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
