package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;

@Mapper
@Repository
public interface TaxiDriverInfoMapper {

    @Results(id = "taxi_drive_info", value = {
            @Result(property = "driverId", column = "driver_id", id = true),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "level", column = "level"),
            @Result(property = "carModel", column = "car_model"),
            @Result(property = "createDttm", column = "create_dttm"),
            @Result(property = "cityId", column = "city_id"),
            @Result(property = "activeStatus", column = "active_status"),
            @Result(property = "numberTips", column = "number_tips"),
            @Result(property = "rating", column = "rating")
    })
    @Select("select * from testliquibase.taxi_service.taxi_drive_info where level = #{level} and city_id = (select id from testliquibase.taxi_service.city_queue where name = #{city}) order by rating desc")
    TaxiDriverInfoModel getDriver(OrderDetails orderDetails);

    @Select("select active_status from testliquibase.taxi_service.taxi_drive_info where driver_id = #{driver_id}")
    boolean getActiveStatus(Long driver_id);

    @Update("update testliquibase.taxi_service.taxi_drive_info set active_status = #{activeStatus} where driver_id = #{driver_id}")
    void setDriverActiveStatus(Long driver_id, boolean activeStatus);


}
