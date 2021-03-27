package com.linebot.controller;

import com.linebot.airtable.AirTableService;
import com.linebot.airtable.entity.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/test")
public class TestController {

    private final AirTableService airTableService;

    public TestController(AirTableService airTableService){
        this.airTableService = airTableService;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(airTableService.getAll());
    }

    @PostMapping
    public ResponseEntity post(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        var log = new Log("jack", "mvc test", now.format(formatter), "Yes");

        return ResponseEntity.status(HttpStatus.CREATED).body(airTableService.create(log));
    }
}
