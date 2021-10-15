package ru.digitalleague.taxi_company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;
import ru.digitalleague.taxi_company.service.TaxiService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TaxiServiceImpl implements TaxiService {

    private final OrderMapper orderMapper;

    private Date currentDate;
    private SimpleDateFormat dateFormat;

    @Autowired
    public TaxiServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    public void addStartTimeTip(Long order_id) {
        currentDate = new Date();
        dateFormat = new SimpleDateFormat(dateFormat.format("yyyy.mm.dd, HH.mm.ss"));
        orderMapper.addStartTimeTip(dateFormat, order_id);

    }

    @Override
    public void addEndTimeTip(Long order_id) {
        currentDate = new Date();
        dateFormat = new SimpleDateFormat(dateFormat.format("yyyy.mm.dd, HH.mm.ss"));
        orderMapper.endStartTimeTip(dateFormat, order_id);
    }

    @Override
    public void createOrder(TaxiDriverInfoModel taxiDriver, OrderDetails orderDetails) {
        orderMapper.createOrder(taxiDriver, orderDetails);
    }

}
