package com.bookkeeping.service.alarms.rules;

import com.bookkeeping.service.alarms.model.AlarmSeverity;
import com.bookkeeping.service.alarms.model.AlarmType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlarmRule {

    private String name;
    private List<Object> values;

    private AlarmSeverity severity;
    private AlarmType alarmType;
    private String description;
    private String resolution;
}
