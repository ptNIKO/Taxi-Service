package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;

import java.text.SimpleDateFormat;

@Mapper
@Repository
public interface OrderMapper {

    @Insert("insert into testliquibase.taxi_service.orders (client_id, driver_id) values (${orderDetails.getClientId()}, ${taxiDriverInfoModel.getDriverId()})")
    void createOrder(TaxiDriverInfoModel taxiDriverInfoModel,  OrderDetails orderDetails);


    @Update("update testliquibase.taxi_service.orders set start_tip = now() where id = ${order_id}")
    void addStartTimeTip(SimpleDateFormat dateFormat, Long order_id);

    @Update("update testliquibase.taxi_service.orders set end_tip = now() where id = ${order_id}")
    void endStartTimeTip(SimpleDateFormat dateFormat, Long order_id);



}
