package ru.digitalleague.taxi_company.utils;

import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.OrderModel;

/**
 * Утилитный класс для преобразования обьектов.
 */
public class OrderConvert {

    public static OrderModel convertOrderDetailsIntoOrder(OrderDetails orderDetails, TaxiDriverInfoModel driver) {

        if (orderDetails == null) return null;

        OrderModel order = new OrderModel();
        order.setClientId(orderDetails.getClientId());
        order.setDriverId(driver.getDriverId());
        return order;
    }
}
