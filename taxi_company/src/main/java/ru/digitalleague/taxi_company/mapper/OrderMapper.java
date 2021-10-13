package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;

import java.text.SimpleDateFormat;

@Mapper
public interface OrderMapper {

    @Insert("insert into testliquibase.taxi_service.orders (client_id, driver_id) values (${orderDetails.getClientId()}, orderDetails.getDriverId())")
    void createOrder(TaxiDriverInfoModel taxiDriverInfoModel,  OrderDetails orderDetails);

    @Update("update testliquibase.taxi_service.orders set start_tip = ${dateFormat} where id = ${order_id}")
    void addStartTimeTip(SimpleDateFormat dateFormat, Long order_id);

    @Update("update testliquibase.taxi_service.orders set end_tip = ${dateFormat} where id = ${order_id}")
    void endStartTimeTip(SimpleDateFormat dateFormat, Long order_id);

    @Select("select * from testliquibase.taxi_service.taxi_drive_info " +
            "where level = ${level} " +
            "and city_id = (select id from testliquibase.taxi_service.city_queue where name = '${city}') " +
            "order by rating asc")
    TaxiDriverInfoModel getDriver(int level, String city);

}
