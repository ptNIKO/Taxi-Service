package ru.digitalleague.core.model;

import lombok.*;

import java.time.OffsetDateTime;

@Data
public class OrderDetails {

    /**
     * Идентификатор заказа.
     */
    private Long orderId;

    /**
     * Идентификатор клиента.
     */
    private Long clientId;

    /**
     * Идентификатор водителя.
     */
    private Long driverId;

    /**
     * Желаемый класс поездки (бизнес, эконом, и т.п.)
     */
    private int level;

    /**
     * Название города.
     */
    private String city;

    /**
     *  Время начала поездки.
     */
    private OffsetDateTime startTripTime;

    /**
     * Время окончания поездки.
     */
    private OffsetDateTime endTripTime;
}
