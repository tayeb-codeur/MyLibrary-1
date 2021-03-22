package com.icc.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Person {
    private String name;
    private int maxBooks;
    private Date registrationDate;

    Person (String name, int maxBooks) {
        this.name = name;
        this.maxBooks = maxBooks;
        this.registrationDate = new Date(System.currentTimeMillis());
    }

    Person() {
        this.name = "Unknown";
        this.maxBooks = 5;
        this.registrationDate = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Nom : " + this.name + " | Livres empruntables : " + this.maxBooks + " | Date d'enregistrement : " + this.registrationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
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
