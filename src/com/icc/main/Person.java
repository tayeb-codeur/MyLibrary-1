package com.icc.main;

import java.util.ArrayList;
import java.util.Date;

public class Person {
    private String name;
    private int maxBooks;
    private Date registrationDate;

    Person (String name, int maxBooks, Date registrationDate) {
        this.name = name;
        this.maxBooks = maxBooks;
        this.registrationDate = registrationDate;
    }

    Person() {
        this.name = "Unknown";
        this.maxBooks = 5;
        this.registrationDate = new Date(System.currentTimeMillis());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
}
