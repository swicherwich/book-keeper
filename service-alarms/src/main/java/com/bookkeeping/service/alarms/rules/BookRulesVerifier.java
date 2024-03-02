package com.bookkeeping.service.alarms.rules;

import com.bookkeeping.service.alarms.model.Alarm;
import com.bookkeeping.service.alarms.model.Book;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookRulesVerifier implements RulesVerifier<Book> {

    private static final String BOOK_RULES_CONFIG = "rules/book-rules.json";

    private List<AlarmRule> rules;

    public BookRulesVerifier() {
        this.rules = RuleMapper.map(BOOK_RULES_CONFIG);
    }

    @Override
    public List<Alarm> verifyRule(Book book) {
        List<Alarm> alarms = new ArrayList<>();

        for (AlarmRule rule : rules) {
            switch (rule.getName()) {
                case "lang": {
                    if (book.getLang() == null) {
                        break;
                    }
                    boolean violates;
                    for (Object obj : rule.getValues()) {
                        if (obj instanceof String str) {
                            violates = book.getLang().equalsIgnoreCase(str);
                            if (violates) {
                                alarms.add(populateAlarm(rule, book));
                            }
                        }
                    }
                    break;
                }
                case "availability": {
                    if (!book.isAvailable()) {
                        alarms.add(populateAlarm(rule, book));
                    }
                    break;
                }
            }
        }

        return alarms;
    }

    private Alarm populateAlarm(AlarmRule rule, Book book) {
        Alarm alarm = new Alarm();
        alarm.setName(rule.getName());
        alarm.setRaiseDate(LocalDateTime.now());
        alarm.setBookId(book.getId());
        alarm.setAlarmType(rule.getAlarmType());
        alarm.setSeverity(rule.getSeverity());
        alarm.setDescription(rule.getDescription());
        alarm.setResolution(rule.getResolution());
        return alarm;
    }

}
