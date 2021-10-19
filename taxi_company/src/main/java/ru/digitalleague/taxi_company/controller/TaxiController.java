package ru.digitalleague.taxi_company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.taxi_company.model.OrderModel;
import ru.digitalleague.taxi_company.service.DriverGradeService;
import ru.digitalleague.taxi_company.service.OrderService;
import ru.digitalleague.taxi_company.service.OrderTotalService;
import ru.digitalleague.taxi_company.service.TaxiDriverInfoService;

@RestController
public class TaxiController {

    @Autowired
    OrderService orderService;

    @Autowired
    private TaxiDriverInfoService taxiDriverInfoService;

    @Autowired
    private OrderTotalService orderTotalService;

    @Autowired
    DriverGradeService driverGradeService;

    /**
     * Метод получает инфо о начале поездки.
     * @param order
     * */
    @PostMapping("/start-trip")
    public ResponseEntity<String> startTrip(@RequestBody OrderModel order) {
        OrderModel orderById = orderService.getOrderById(order.getId());
        orderService.updateStartOrderTime(orderById);

        orderService.getDriverIdByOrderId(order.getId());
        taxiDriverInfoService.setDriverActiveStatus(orderById.getDriverId());


        System.out.println("Trip is start");
        return ResponseEntity.ok("Поездка началась");
    }

    /**
     * Метод получает инфо о завершении поездки.
     * @param order
     * */
    @PostMapping("/finish-trip")
    public ResponseEntity<String> finishTrip(@RequestBody OrderModel order) {
        OrderModel orderById = orderService.getOrderById(order.getId());
        orderService.updateFinishOrderTime(orderById);

        orderService.getDriverIdByOrderId(order.getId());
        taxiDriverInfoService.setDriverActiveStatus(orderById.getDriverId());

        Long orderPrice = orderTotalService.countPrice(order.getId());

        System.out.println("Trip is finished");
        return ResponseEntity.ok("Услуга оказана\n" + "Цена поездки: " + orderPrice + " рублей");
    }

    @PostMapping("/grade")
    public ResponseEntity<String>rateDriver(@RequestBody OrderModel order) {
        OrderModel orderById = orderService.getOrderById(order.getId());
        orderService.setGrade(order.getId(), order.getGrade()); // Добавление оценки в ордер

        driverGradeService.updateGrade(orderById.getDriverId(), order.getGrade());
        taxiDriverInfoService.updateRating(orderById.getDriverId(), order.getGrade());
        return ResponseEntity.ok("Спасибо, что оценили поездку");
    }
}