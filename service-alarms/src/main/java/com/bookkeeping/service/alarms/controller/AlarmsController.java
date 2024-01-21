package com.bookkeeping.service.alarms.controller;

import com.bookkeeping.service.alarms.model.Alarm;
import com.bookkeeping.service.alarms.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alarms")
public class AlarmsController {

    @Autowired
    private AlarmRepository alarmRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Alarm>> getAllBooksAlarms() {
        return ResponseEntity.ok(alarmRepository.findAll());
    }

}
