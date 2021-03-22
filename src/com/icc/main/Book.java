package com.icc.main;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private Person person;
    private int totalPages;
    private int loanPeriod;
    private int rentalPrice;
    private Date borrowingDate;
    private String language;

    Book (String title, String author, Person person, int totalPages, int loanPeriod, int rentalPrice, Date borrowingDate, String language) {
        this.title = title;
        this.author = author;
        this.person = person;
        this.totalPages = totalPages;
        this.loanPeriod = loanPeriod;
        this.rentalPrice = rentalPrice;
        this.borrowingDate = borrowingDate;
        this.language = language;
    }

    Book() {
        this.title = "Title";
        this.author = "Author";
        this.person = null;
        this.totalPages = 0;
        this.loanPeriod = 0;
        this.rentalPrice = 0;
        this.borrowingDate = new Date(System.currentTimeMillis());
        this.language = "French";
    }

    @Override
    public String toString() {
        return "Titre : " + this.title + " Auteur : " + this.author + "Emprunteur : " + this.person + " Nombre de pages : " + this.totalPages + " Loan Period : " + this.loanPeriod + " Coût : " + this.rentalPrice + " Date d'emprunt : " + this.borrowingDate.toString() + " Langue : " + this.language;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    // # # # TEST PUSH # # # 
 // # # # TEST PUSH BIS # # # 
}
