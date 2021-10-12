package ru.digitalleague.core.service;

import ru.digitalleague.core.model.SearchDriverModel;
import ru.digitalleague.core.model.TaxiDriverInfoModel;

public interface SearchDriverService {

    TaxiDriverInfoModel findDriver(SearchDriverModel searchDriverModel);
}
