package com.bookkeeping.service.alarms.service;

import com.bookkeeping.service.alarms.model.Alarm;
import com.bookkeeping.service.alarms.model.Book;
import com.bookkeeping.service.alarms.repository.AlarmRepository;
import com.bookkeeping.service.alarms.rules.BookRulesVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class BookAlarmService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${info.service.api.book}")
    private String bookInfoServiceApi;

    @Autowired
    private AlarmRepository alarmRepository;

    @Autowired
    private BookRulesVerifier bookRulesVerifier;

    @Scheduled(initialDelay = 5, fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    private void job() {
        ResponseEntity<Book[]> booksRes = restTemplate.getForEntity(URI.create(bookInfoServiceApi), Book[].class);
        if (booksRes.getStatusCode().equals(HttpStatus.OK)) {
            handleAlarms(getBookList(booksRes));
        }
    }

    private List<Book> getBookList(ResponseEntity<Book[]> resp) {
        return List.of(Objects.requireNonNull(resp.getBody(), "Book info service responded with null body."));
    }

    private void handleAlarms(List<Book> books) {
        for (Book book : books) {
            List<Alarm> alarms = bookRulesVerifier.verifyRule(book);
            for (Alarm alarm : alarms) {
                Optional<Alarm> optionalAlarm = alarmRepository.findAlarmByNameAndBookId(alarm.getName(), alarm.getBookId());
                if (optionalAlarm.isEmpty()) {
                    alarmRepository.save(alarm);
                }
            }
        }
    }

}
