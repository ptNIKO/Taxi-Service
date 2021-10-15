package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.OrderModel;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;

import java.text.SimpleDateFormat;

@Mapper
@Repository
public interface OrderMapper {

    /**
     * Сохранить заказ.
     *
     * @param order информация о заказе.
     */
    @Insert("insert into orders (id, client_id, driver_id, start_trip, end_trip)" +
            "        values(#{orderId}, #{clientNumber}, #{driverId}, #{startTrip}, #{endTrip})")
    @SelectKey(statement = "select nextval('order_seq')", keyProperty = "orderId", before = true, resultType = Long.class)
    void saveOrder(OrderModel order);

    /**
     * Поиск заказа по идентификатору.
     *
     * @param orderId идентификатор заказа.
     * @return заказ
     */
    @Select("select id, client_id, driver_id, start_trip, end_trip " +
            "        from orders " +
            "        where id = #{orderId}")
    OrderModel getOrderById(Long orderId);

    /**
     * Обновление времени заказа.
     *
     * @param order инфорамция о заказе.
     */
    @Update("update orders " +
            "        set start_trip    = now() " +
            "        where id = #{orderId}")
    void updateStartOrderTime(OrderModel order);

    /**
     * Обновление времени заказа.
     *
     * @param order инфорамция о заказе.
     */
    @Update("update orders " +
            "        set end_trip = now() " +
            "        where id = #{orderId}")
    void updateFinishOrderTime(OrderModel order);

}
