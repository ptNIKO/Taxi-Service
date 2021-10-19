package ru.digitalleague.taxi_company.service;

import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.OrderModel;

import java.time.OffsetDateTime;

public interface OrderService {

    void setOrder(OrderModel order);

    OrderModel getOrderById(Long orderId);

    Long getDriverIdByOrderId(Long orderId);

    void updateStartOrderTime(OrderModel order);

    void updateFinishOrderTime(OrderModel order);

    void proceedOrder(OrderDetails orderDetails);

    OffsetDateTime getStartOrderTime(Long orderId);

    OffsetDateTime getFinishOrderTime(Long orderId);

    void setGrade(Long orderId, double grade);
}
