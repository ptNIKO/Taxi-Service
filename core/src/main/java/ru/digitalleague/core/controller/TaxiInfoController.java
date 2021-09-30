package ru.digitalleague.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.core.model.TaxiDriverInfoModel;
import ru.digitalleague.core.service.TaxiInfoService;

@RestController
public class TaxiInfoController {

    @Autowired
    private TaxiInfoService taxiInfoService;

    @PostMapping("/insert")
    public void insert(@RequestBody TaxiDriverInfoModel taxiDriverInfoModel) {
        taxiInfoService.insert(taxiDriverInfoModel);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        TaxiDriverInfoModel taxiDriverInfoModel = taxiInfoService.selectByPrimaryKey(id);
        taxiInfoService.deleteById(taxiDriverInfoModel.getDriverId());
        return "DELETE";
    }

    @PutMapping("/update{id}")
    public void update(@PathVariable long id) {
        TaxiDriverInfoModel taxiDriverInfoModel1 = taxiInfoService.selectByPrimaryKey(id);
        taxiInfoService.update(taxiDriverInfoModel1.getDriverId());
    }

    @GetMapping("/get/{id}")
    public void get(@PathVariable long id) {
        TaxiDriverInfoModel taxiDriverInfoModel = taxiInfoService.selectByPrimaryKey(id);
        System.out.println(taxiDriverInfoModel.toString());
    }
}
