package com.icc.main;

/**
 * Définit le type de livre
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1 (24.03.21)
 */

import java.time.LocalDate;


public class Book {
    private String title;
    private String author;
    private String language;
    private int totalPages;

    private int loanPeriod;
    private int rentalPrice;

    private Person borrower;
    public LocalDate borrowingDate;

    /**
     * Crée un livre et définit son type
     * 
     * @param 	title - Le titre du livre
     * 			author - l'auteur
     * 			borrower - la personne qui a emprunté le livre
     * 			totalPages - le nombre de pages total
     * 			loanPeriod - période de prêt
     * 			rentalPrice - prix de location
     * 			language - langue du livre
     */
    
    public Book (String title, String author, Person borrower, int totalPages, int loanPeriod, int rentalPrice, String language) {
        this.title = title;
        this.author = author;
        this.borrower = borrower;
        this.totalPages = totalPages;
        this.loanPeriod = loanPeriod;
        this.rentalPrice = rentalPrice;
        this.language = language;
    }

    /**
     * Crée un livre et laisse libre champs à l'utilisateur
     */
    Book() {
        this.title = "Title";
        this.author = "Author";
        this.borrower = null;
        this.totalPages = 0;
        this.loanPeriod = 0;
        this.rentalPrice = 0;
        this.language = "French";
    }


    /**
     * @return toString de la classe Book
     */
    @Override
    public String toString() {
        return "Titre : " + this.title + " Auteur : " + this.author + "Emprunteur : " + this.borrower + " Nombre de pages : " + this.totalPages + " Loan Period : " + this.loanPeriod + " Coût : " + this.rentalPrice + " Date d'emprunt : " + this.borrowingDate.toString() + " Langue : " + this.language;
    }


    /**
     * Modifie le titre du livre 
     * @param title / Le nouveau titre du livre
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Renvoi le titre du livre
     * @return le titre du livre
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifie l'auteur du livre 
     * @param author / Le nouvel auteur du livre
     */
    public void setAuthor(String author) {
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }

    /**
     * Modifie le locataire du livre 
     * @param borrower / Le nouveau locataire du livre
     */
    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        this.borrowingDate = LocalDate.now();
    }

    /**
     * Renvoi le locataire du livre
     * @return le locataire du livre
     */
    public Person getBorrower() {
        return borrower;
    }

    /**
     * Modifie le nombre de pages total du livre 
     * @param totalPages / Le nouveau nombre de pages totales du livre
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }


    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Modifie le prix de location du livre
     * @param rentalPrice / Le nouveu prix de location
     */
    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }


    public int getRentalPrice() {
        return rentalPrice;
    }

    /**
     * Modifie la période de prêt du livre
     * @param loanPeriod / La nouvelle période de prêt du livre
     */
    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }


    public int getLoanPeriod() {
        return loanPeriod;
    }

    /**
     * Modifie la langue du livre
     * @param language / La nouvelle langue du livre
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public Integer computeRemainingDays() {
        return borrowingDate.plusDays((long)this.loanPeriod).compareTo( LocalDate.now());
    }
}
