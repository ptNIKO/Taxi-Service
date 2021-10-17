package ru.digitalleague.taxi_company.service;

import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.OrderModel;

public interface OrderService {

    void saveOrder(OrderModel order);

    OrderModel getOrderById(Long orderId);

    Long getDriverIdByOrderId(Long orderId);

    void updateStartOrderTime(OrderModel order);

    void updateFinishOrderTime(OrderModel order);

    void proceedOrder(OrderDetails orderDetails);

}
