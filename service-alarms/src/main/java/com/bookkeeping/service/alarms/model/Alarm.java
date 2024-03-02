package com.bookkeeping.service.alarms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "alarm")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "raise_date", nullable = false)
    private LocalDateTime raiseDate;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity", nullable = false)
    private AlarmSeverity severity;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AlarmType alarmType;

    @Column(name = "book_id", nullable = false)
    private String bookId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "proposed_resolution", nullable = false)
    private String resolution;
}
