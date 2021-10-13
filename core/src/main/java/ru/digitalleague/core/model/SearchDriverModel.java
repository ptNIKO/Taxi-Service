package ru.digitalleague.core.model;

import lombok.Data;
import lombok.ToString;

/**
 * Модель поиска такси.
 */
@Data
public class SearchDriverModel {

    /**
     * Город.
     */
    private String city;

    /**
     * Уровень.
     */
    private int level;

}
