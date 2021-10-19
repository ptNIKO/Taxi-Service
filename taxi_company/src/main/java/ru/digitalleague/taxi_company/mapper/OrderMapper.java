package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.OrderModel;

import java.time.OffsetDateTime;

@Mapper
@Repository
public interface OrderMapper {

    /**
     * Сохранить заказ.
     *
     * @param order информация о заказе.
     */
    @Insert("insert into testliquibase.taxi_service.orders (id, client_id, driver_id, start_trip, end_trip)" +
            "        values(#{id}, #{clientId}, #{driverId}, #{startTrip}, #{endTrip})")
    @SelectKey(statement = "select nextval('testliquibase.taxi_service.orders_seq')", keyProperty = "id", before = true, resultType = Long.class)
    void setOrder(OrderModel order);

    /**
     * Поиск заказа по идентификатору.
     *
     * @param orderId идентификатор заказа.
     * @return заказ
     */
    @Select("select id, client_id, driver_id, start_trip, end_trip " +
            "        from testliquibase.taxi_service.orders " +
            "        where id = #{orderId}")
    OrderModel getOrderById(Long orderId);

    /**
     * Поиск id водителя.
     *
     * @param orderId идентификатор заказа.
     */
    @Select("select driver_id from testliquibase.taxi_service.orders where id = #{orderId}")
    Long getDriverIdByOrderId(Long orderId);

    /**
     * Обновление времени заказа.
     *
     * @param order инфорамция о заказе.
     */
    @Update("update testliquibase.taxi_service.orders " +
            "        set start_trip  = now() " +
            "        where id = #{id}")
    void updateStartOrderTime(OrderModel order);

    /**
     * Обновление времени заказа.
     *
     * @param order инфорамция о заказе.
     */
    @Update("update testliquibase.taxi_service.orders " +
            "        set end_trip = now() " +
            "        where id = #{id}")
    void updateFinishOrderTime(OrderModel order);

    /**
     * Получение времени начала поездки.
     *
     * @param orderId Идетификатор заказа .
     */
    @Select("select start_trip from testliquibase.taxi_service.orders " +
            "where id = #{orderId}")
    OffsetDateTime getStartOrderTime(Long orderId);

    /**
     * Получение времени окончания поездки.
     *
     * @param orderId  Идетификатор заказа.
     */
    @Select("select end_trip from testliquibase.taxi_service.orders " +
            "where id = #{orderId}")
    OffsetDateTime getFinishOrderTime(Long orderId);

    /**
     * Выставление оценки клиента за поездку
     *
     * @param orderId
     * @param grade
     */
    @Update("update testliquibase.taxi_service.orders set grade = #{grade} " +
            "where id = #{orderId}")
    void setGrade(Long orderId, double grade);
}
