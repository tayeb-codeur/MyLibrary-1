package com.icc.main;

import java.util.Date;

public class OnlineBook extends Book{
    private int maxPeople;
    private String content;

    OnlineBook(String title, String author, Person person, int totalPages, int loanPeriod, int rentalPrice, Date borrowingDate, String language, int maxPeople, String content){
        super(title, author, person, totalPages, loanPeriod, rentalPrice, borrowingDate, language);
        this.maxPeople = maxPeople;
        this.content = content;
    }

    OnlineBook() {
        super();
        this.maxPeople = 0;
        this.content = "Unknown";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
}
