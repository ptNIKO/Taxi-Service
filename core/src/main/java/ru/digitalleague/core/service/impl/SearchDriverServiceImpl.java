package ru.digitalleague.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.core.mapper.SearchDriverMapper;
import ru.digitalleague.core.mapper.TaxiInfoMapper;
import ru.digitalleague.core.model.SearchDriverModel;
import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.core.service.SearchDriverService;


@Service
public class SearchDriverServiceImpl implements SearchDriverService {

    @Autowired
    private SearchDriverMapper searchDriverMapper;

    @Override
    public TaxiDriverInfoModel findDriver(SearchDriverModel searchDriverModel) {
        return searchDriverMapper.findDriver(searchDriverModel.getLevel(),
                searchDriverModel.getCity());
    }
}
