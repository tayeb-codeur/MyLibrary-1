package com.icc.main;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private int totalPages;
    private int loanPeriod;
    private int rentalPrice;
    private Date borrowingDate;
    private String language;

    Book (String title, String author, int totalPages, int loanPeriod, int rentalPrice, Date borrowingDate, String language) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this. rentalPrice = rentalPrice;
        this.borrowingDate = borrowingDate;
        this. language = language;
    }

    Book() {
        this.title = "Title";
        this.author = "Author";
        this.totalPages = 0;
        this.loanPeriod = 0;
        this.rentalPrice = 0;
        this.borrowingDate = new Date(System.currentTimeMillis());
        this.language = "French";
    }
}
