package ru.digitalleague.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import ru.digitalleague.core.model.TaxiDriverInfoModel;

@Repository
@Mapper
public interface TaxiInfoMapper {

    @Select("select count(1) from taxi_drive_info")
    int getCount();

    @Insert("insert into testliquibase.test.taxi_drive_info " +
            "(last_name, first_name, level, car_model, create_dttm)" +
            "values (#{lastName}, #{firstName}, #{level}, #{carModel}, #{createDttm})")
    int insert(TaxiDriverInfoModel record);

    @Delete("delete from testliquibase.test.taxi_drive_info where driver_id = #{driverId} ")
    int deleteById(long driverId);

    @Update("update testliquibase.test.taxi_drive_info\n" +
            "        set last_name = #{lastName},\n" +
            "        first_name = #{firstName},\n" +
            "        \"level\" = #{level},\n" +
            "        car_model = #{carModel},\n" +
            "        create_dttm = #{createDttm}\n" +
            "        where driver_id = #{driverId}")
    int update(long driverId);


    @Results(id = "drivers", value = {
            @Result(property = "driverId", column = "driver_id"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "firstName", column = "first_name"),
            //@Result(property = "middleName", column = "middle_name"),
            @Result(property = "level", column = "level"),
            @Result(property = "carModel", column = "car_model"),
            @Result(property = "createDttm", column = "create_dttm")
    })
    @Select("SELECT driver_id, last_name, first_name, level, car_model, create_dttm FROM taxi_drive_info")
    List<TaxiDriverInfoModel> getAllDrivers();

    /**
     * Находим очередь, в которую будем отправлять сообщения по названию города.
     * */
    @Select("SELECT queue FROM city_queue where name = #{cityName}")
    String getQueueByCity(String cityName);


    @Select("select * from testliquibase.test.taxi_drive_info where driver_id = #{driverId}")
    TaxiDriverInfoModel selectByPrimaryKey(long driverId);

    int updateByPrimaryKey(TaxiDriverInfoModel record);

    List<TaxiDriverInfoModel> selectByLastName(String lastName);
}
