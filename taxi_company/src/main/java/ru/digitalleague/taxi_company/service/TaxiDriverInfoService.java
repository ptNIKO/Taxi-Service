package ru.digitalleague.taxi_company.service;

import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.model.OrderDetails;

public interface TaxiDriverInfoService {

    TaxiDriverInfoModel findDriver(OrderDetails orderDetails);

    void setDriverActiveStatus(Long driverId);

}
