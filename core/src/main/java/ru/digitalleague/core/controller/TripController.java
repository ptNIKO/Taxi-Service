package ru.digitalleague.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.core.model.SearchDriverModel;
import ru.digitalleague.core.service.SearchDriverService;

@RestController
public class TripController {

    @Autowired
    private SearchDriverService searchDriverService;


    @PostMapping("/find")
    public ResponseEntity<String> searchDriver(@RequestBody SearchDriverModel searchDriverModel) {
        System.out.println("Ваш водитель найден " + searchDriverService.findDriver(searchDriverModel).toString());
        System.out.println("Поездка началась");
        return ResponseEntity.ok("Старт поездки");
    }
}
