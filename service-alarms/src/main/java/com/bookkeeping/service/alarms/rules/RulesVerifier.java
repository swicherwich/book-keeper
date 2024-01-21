package com.bookkeeping.service.alarms.rules;

import com.bookkeeping.service.alarms.model.Alarm;

import java.util.List;

public interface RulesVerifier<T> {

    List<Alarm> verifyRule(T t);
}
