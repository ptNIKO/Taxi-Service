package ru.digitalleague.core.api;

import ru.digitalleague.core.model.OrderDetails;
import ru.digitalleague.core.model.SearchDriverModel;

public interface TaxiService {

    /**
     * Информируем такси о поступлении заказа.
     */
    String notifyTaxi(OrderDetails orderDetails);
}
