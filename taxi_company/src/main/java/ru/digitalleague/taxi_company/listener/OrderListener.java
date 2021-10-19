package ru.digitalleague.taxi_company.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.service.OrderService;


@Component
@Slf4j
public class OrderListener implements MessageListener{

    @Autowired
    private OrderService orderService;


    @SneakyThrows
    @RabbitListener(queues = "${application.broker.receive-queue}")
    @Override
    public void onMessage(Message message) {
        log.info("Received message from rabbitmq Test " + message);
        ObjectMapper  objectMapper = new ObjectMapper();


        OrderDetails orderDetails = objectMapper.readValue(message.getBody(), OrderDetails.class);

        if (orderDetails != null) {
            orderService.proceedOrder(orderDetails);
        }

    }

}
