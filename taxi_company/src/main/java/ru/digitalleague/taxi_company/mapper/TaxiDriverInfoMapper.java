package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.model.OrderDetails;

@Mapper
@Repository
public interface TaxiDriverInfoMapper {

    @Results(id = "drivers", value = {
            @Result(property = "driverId", column = "driver_id"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "level", column = "level"),
            @Result(property = "carModel", column = "car_model"),
            @Result(property = "createDttm", column = "create_dttm")
    })
    @Select("select driver_id,last_name,first_name, level, car_model, create_dttm, city_id, is_busy, number_tips, rating from testliquibase.taxi_service.taxi_drive_info " +
            "where level = #{level} and city_id = (select id from testliquibase.taxi_service.city_queue where name = #{city}) " +
            "and is_busy = 'false'" +
            "order by rating desc " +
            "limit 1")
    TaxiDriverInfoModel findDriver(OrderDetails orderDetails);

    @Select("select is_busy from testliquibase.taxi_service.taxi_drive_info where driver_id = #{driverId}")
    boolean getActiveStatus(Long driverId);

    @Update("update testliquibase.taxi_service.taxi_drive_info set is_busy = #{activeStatus} where driver_id = #{driverId}")
    boolean setDriverActiveStatus(Long driverId, boolean activeStatus);


}
