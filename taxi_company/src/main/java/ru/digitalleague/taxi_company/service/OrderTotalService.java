package ru.digitalleague.taxi_company.service;

public interface OrderTotalService {

    Long countPrice(Long orderId);

    void addOrderPrice(Long orderId, Long cost);
}
