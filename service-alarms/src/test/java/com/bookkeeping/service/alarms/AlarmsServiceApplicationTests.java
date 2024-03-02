package com.bookkeeping.service.alarms;

import com.bookkeeping.service.alarms.model.Alarm;
import com.bookkeeping.service.alarms.model.AlarmType;
import com.bookkeeping.service.alarms.model.Book;
import com.bookkeeping.service.alarms.rules.BookRulesVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AlarmsServiceApplicationTests {

	private BookRulesVerifier bookRulesVerifier = new BookRulesVerifier();

	@Test
	void shouldPassLangRule() {
		Book book = new Book();
		book.setLang("ua");
		List<Alarm> alarms = bookRulesVerifier.verifyRule(book);
        Assertions.assertTrue(alarms.isEmpty());
	}

	@Test
	void shouldFailLangRule() {
		Book book = new Book();
		book.setLang("ru");
		List<Alarm> alarms = bookRulesVerifier.verifyRule(book);
		Assertions.assertEquals(1, alarms.size());
		Assertions.assertEquals(AlarmType.BOOK_SPECIFIC, alarms.get(0).getAlarmType());
	}

	@Test
	void shouldPassLoanRule() {
		Book book = new Book();
		book.setAvailable(true);
		List<Alarm> alarms = bookRulesVerifier.verifyRule(book);
		Assertions.assertTrue(alarms.isEmpty());
	}

	@Test
	void shouldFailLoanRule() {
		Book book = new Book();
		book.setAvailable(false);
		List<Alarm> alarms = bookRulesVerifier.verifyRule(book);
		Assertions.assertEquals(1, alarms.size());
		Assertions.assertEquals(AlarmType.BOOK_LOAN, alarms.get(0).getAlarmType());
	}

	@Test
	void shouldFailLoanAndLangRule() {
		Book book = new Book();
		book.setLang("ru");
		book.setAvailable(false);
		List<Alarm> alarms = bookRulesVerifier.verifyRule(book);
		Assertions.assertEquals(2, alarms.size());
		boolean loanSpecificRuleFailed = alarms.stream().anyMatch(alarm -> alarm.getAlarmType().equals(AlarmType.BOOK_LOAN));
		boolean bookSpecificRuleFailed = alarms.stream().anyMatch(alarm -> alarm.getAlarmType().equals(AlarmType.BOOK_SPECIFIC));
		Assertions.assertTrue(loanSpecificRuleFailed);
		Assertions.assertTrue(bookSpecificRuleFailed);

	}

}
