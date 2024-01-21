package com.bookkeeping.service.alarms.repository;

import com.bookkeeping.service.alarms.model.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlarmRepository extends JpaRepository<Alarm, String> {
    Optional<Alarm> findAlarmByNameAndBookId(String name, String id);
}
