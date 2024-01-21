package com.bookkeeping.service.alarms.model;

public enum AlarmSeverity {
    WARNING,
    CRITICAL;

//    public AlarmSeverity valueOf(String v) {
//        switch (v) {
//            case "WARNING", "warning" -> {
//                return WARNING;
//            }
//            case "CRITICAL", "critical" -> {
//                return CRITICAL;
//            }
//            default -> throw new IllegalArgumentException("Provided value " + v + " does not correspond to enum type");
//        }
//    }
}
