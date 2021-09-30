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
    public void delete(@PathVariable long id) {
        taxiInfoService.deleteById(id);
        System.out.println("Is delete");
    }

    @PutMapping("/update{id}")
    public void update(@PathVariable long id) {
        taxiInfoService.update(id);
    }

    @GetMapping("/get/{id}")
    public TaxiDriverInfoModel get(@PathVariable long id) {
        TaxiDriverInfoModel taxiDriverInfoModel = taxiInfoService.selectByPrimaryKey(id);
        return taxiDriverInfoModel;
    }
}
