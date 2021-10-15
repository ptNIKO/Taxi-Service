package ru.digitalleague.taxi_company.service;

import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;

public interface TaxiDriverInfoService {

    TaxiDriverInfoModel getDriver(OrderDetails orderDetails);

    void setDriverActiveStatus(Long driver_id, boolean activeStatus);

}
