package ru.digitalleague.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.digitalleague.core.model.SearchDriverModel;
import ru.digitalleague.core.model.TaxiDriverInfoModel;

@Mapper
public interface SearchDriverMapper {

    @Select("select * from testliquibase.taxi_service.taxi_drive_info " +
            "where level = ${level} " +
            "and city_id = (select id from testliquibase.taxi_service.city_queue where name = '${city}') " +
            "order by rating asc")
    TaxiDriverInfoModel findDriver(int level, String city);
}
