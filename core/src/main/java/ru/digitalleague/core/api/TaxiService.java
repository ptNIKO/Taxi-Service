package ru.digitalleague.core.api;

import ru.digitalleague.core.model.OrderDetails;

public interface TaxiService {

    /**
     * Информируем такси о поступлении заказа.
     */
    String notifyTaxi(OrderDetails orderDetails);
}
