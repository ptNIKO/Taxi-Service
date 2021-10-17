package ru.digitalleague.taxi_company.model;


import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class OrderModel {

    /**
     * Идентификатор заказа.
     */
    private Long id;

    /**
     * Идентификатор клиента.
     */
    private Long clientId;

    /**
     * Идентификатор водителя.
     */
    private Long driverId;

    /**
     * Дата, время начала поездки.
     */
    private OffsetDateTime startTrip;

    /**
     * Дата, время окончания поездки.
     */
    private OffsetDateTime endTrip;
}
