package ru.digitalleague.core.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Data
@Builder
public class TaxiDriverInfoModel {

    /**
     * Идентификатор водителя.
     */
    private Long driverId;

    /**
     * Фамилия.
     */
    private String lastName;

    /**
     * Имя.
     */
    private String firstName;

    /**
     * Уровень.
     */
    private int level;

    /**
     * Модель авто (должна быть ENUM).
     */
    private String carModel;

    /**
     * Дата создания.
     */
    private Date createDttm;
}
