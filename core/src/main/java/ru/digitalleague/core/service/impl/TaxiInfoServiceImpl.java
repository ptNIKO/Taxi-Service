package ru.digitalleague.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.digitalleague.core.mapper.TaxiInfoMapper;
import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.core.service.TaxiInfoService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaxiInfoServiceImpl implements TaxiInfoService {


    private final TaxiInfoMapper taxiInfoMapper;

    @Override
    public int insert(TaxiDriverInfoModel record) {
        return taxiInfoMapper.insert(record);
    }

    @Override
    public int deleteById(Long driverId) {
        return taxiInfoMapper.deleteById(driverId);
    }

    @Override
    public int update(Long driverId) {
        return taxiInfoMapper.update(driverId);
    }

    @Override
    public TaxiDriverInfoModel selectByPrimaryKey(Long driverId) {
        return taxiInfoMapper.selectByPrimaryKey(driverId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int updateByPrimaryKey(TaxiDriverInfoModel record) {
        return taxiInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Retryable
    public int getByIdAndUpdateLevel(Long driverId) {
        TaxiDriverInfoModel taxiDriverInfoModel = selectByPrimaryKey(driverId);
        taxiDriverInfoModel.setLevel(taxiDriverInfoModel.getLevel() + 1);
        return taxiInfoMapper.updateByPrimaryKey(taxiDriverInfoModel);
    }

    @SneakyThrows
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean twoSelectByIdWithSleep() {
        String lastName = "Иванов";
        List<TaxiDriverInfoModel> expected = taxiInfoMapper.selectByLastName(lastName);
        log.debug("Expected size: {}", expected.size());
        Thread.sleep(5000);
        List<TaxiDriverInfoModel> actual = taxiInfoMapper.selectByLastName(lastName);
        log.debug("Actual size: {}", actual.size());
        return expected.size() == actual.size();
    }
}
