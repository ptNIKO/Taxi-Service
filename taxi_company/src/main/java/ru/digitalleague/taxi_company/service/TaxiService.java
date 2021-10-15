package ru.digitalleague.taxi_company.service;

import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;

public interface TaxiService {

    void createOrder(TaxiDriverInfoModel taxiDriver,  OrderDetails orderDetails);

    void addStartTimeTip(Long order_id);

    void addEndTimeTip(Long order_id);

}
