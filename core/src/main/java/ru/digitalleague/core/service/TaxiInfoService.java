package ru.digitalleague.core.service;

import ru.digitalleague.core.model.TaxiDriverInfoModel;

import java.util.List;

public interface TaxiInfoService {

    int insert(TaxiDriverInfoModel record);

    int deleteById(Long driverId);

    int update(Long driverId);


    TaxiDriverInfoModel selectByPrimaryKey(Long driverId);

    int updateByPrimaryKey(TaxiDriverInfoModel record);

    int getByIdAndUpdateLevel(Long driverId);

    boolean twoSelectByIdWithSleep();
}
