package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DriverGradeMapper {

    @Select("select sum_grade from testliquibase.taxi_service.drivers_grade where driver_id = #{driverId}")
    int getDriverGradeSumById(Long driverId);

    @Select("select sum_trip from testliquibase.taxi_service.drivers_grade where driver_id = #{driverId}")
    int getDriverTripSumById(Long driverId);

    @Update("update testliquibase.taxi_service.drivers_grade set sum_trip = sum_trip + 1 " +
            "where driver_id = #{driverId}")
    void updateSumTrip(Long driverId);

    @Update("update testliquibase.taxi_service.drivers_grade set sum_grade = sum_grade + #{grade} " +
            "where driver_id = #{driverId}")
    void updateGrade(Long driverId, int grade);
}
