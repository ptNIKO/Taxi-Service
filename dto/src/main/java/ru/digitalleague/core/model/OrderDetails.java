package ru.digitalleague.core.model;

import lombok.*;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class OrderDetails {

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
     * Идентификатор города.
     */
    private Long cityId;

}
