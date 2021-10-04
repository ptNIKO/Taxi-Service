package ru.digitalleague.core.mapper;


import org.apache.ibatis.annotations.*;
import ru.digitalleague.core.model.Car;

@Mapper
public interface CarMapper {

    @Select("select * from testliquibase.test.car where id = #{carId}")
    Car getById(Long carId);

    @Insert("insert into testliquibase.test.car (model, createdttm) values (#{model}, #{createDttm})")
    void insert(Car car);

    @Delete("delete from testliquibase.test.car where id = #{carId}")
    int delete(Long carId);

    @Update("update testliquibase.test.car set model = #{model}, createdttm = #{createDttm}")
    int update(Long carId);
}
