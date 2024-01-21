package com.bookkeeping.service.alarms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private String id;
    private String title;
    private String author;
    private String publisher;
    private String lang;
    private int pages;
    private boolean available = true;
}
