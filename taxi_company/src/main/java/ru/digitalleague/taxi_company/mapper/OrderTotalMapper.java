package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderTotalMapper {

    @Insert("insert into testliquibase.taxi_service.order_total (order_id,cost) values (#{orderId}, #{cost})")
    void addOrderPrice(Long orderId, Long cost);
}
