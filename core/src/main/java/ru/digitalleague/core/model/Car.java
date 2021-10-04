package ru.digitalleague.core.model;

import lombok.*;

import java.time.OffsetDateTime;


@Data
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Long car_id;

    private String model;

    private OffsetDateTime createDttm;
}
