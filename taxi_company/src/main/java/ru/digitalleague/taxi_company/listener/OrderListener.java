package ru.digitalleague.taxi_company.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.mapper.TaxiDriverInfoMapper;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.service.TaxiDriverInfoService;
import ru.digitalleague.taxi_company.service.TaxiService;

import java.io.DataInput;
import java.io.IOException;


@Component
@Slf4j
public class OrderListener implements MessageListener{

    @Autowired
    private TaxiService taxiService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private TaxiDriverInfoService taxiDriverInfoService;

    private ObjectMapper objectMapper;
    private TaxiDriverInfoModel taxiDriver;
    private OrderDetails orderDetails;


    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        log.info("Received message from rabbitmq Test " + message);
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

       // byte[] body = message.getBody();
        orderDetails = objectMapper.readValue(message.getBody(), OrderDetails.class);

        taxiDriver = taxiDriverInfoService.getDriver(orderDetails);
        taxiDriverInfoService.getDriver(orderDetails);
        taxiDriverInfoService.setDriverActiveStatus(taxiDriver.getDriverId(), true);
        taxiService.createOrder(taxiDriver, orderDetails);
    }

}
