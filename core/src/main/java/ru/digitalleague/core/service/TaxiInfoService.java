package ru.digitalleague.core.service;

import ru.digitalleague.core.model.TaxiDriverInfoModel;

import java.util.List;

public interface TaxiInfoService {

    int insert(TaxiDriverInfoModel record);

    int deleteById(long driverId);

    int update(long driverId);


    TaxiDriverInfoModel selectByPrimaryKey(long driverId);

    int updateByPrimaryKey(TaxiDriverInfoModel record);

    int getByIdAndUpdateLevel(Long driverId);

    boolean twoSelectByIdWithSleep();
}
