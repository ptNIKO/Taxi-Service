package ru.digitalleague.taxi_company.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.service.TaxiService;

import java.io.DataInput;


@Component
@Slf4j
public class OrderListener implements MessageListener {

    @Autowired
    private TaxiService taxiService;
    private OrderMapper orderMapper;

    private ObjectMapper mapper;
    private TaxiDriverInfoModel taxiDriver;
    private OrderDetails orderDetails;


    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        log.info("Received message from rabbitmq Test " + message);

        orderDetails = mapper.readValue((DataInput) message, OrderDetails.class);

        taxiDriver = orderMapper.getDriver(orderDetails.getLevel(), orderDetails.getCity());

        taxiService.createOrder(taxiDriver, orderDetails);
    }
}
