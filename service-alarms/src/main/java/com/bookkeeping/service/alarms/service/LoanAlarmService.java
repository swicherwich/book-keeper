package com.bookkeeping.service.alarms.service;

import com.bookkeeping.service.alarms.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanAlarmService {

    @Autowired
    private AlarmRepository alarmRepository;
}
