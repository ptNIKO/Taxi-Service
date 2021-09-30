package ru.digitalleague.core.mapper;


import org.apache.ibatis.annotations.*;
import ru.digitalleague.core.model.Car;

@Mapper
public interface CarMapper {

    @Select("select * from car where id = #{carId}")
    Car getById(long carId);

    @Insert("insert into car (model, createdttm) values (#{model}, #{createDttm})")
    void insert(Car car);

    @Delete("delete from car where id = #{carId}")
    int delete(long carId);

    @Update("update car set model = #{model}, createdttm = #{createDttm}")
    int update(long carId);
}
