package com.icc.main;

import java.time.LocalDate;

/**
 * Définit la classe Book (un livre de la bibliothèque)
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1
 */

public class Book {
    /**
     * Le titre du livre
     */
    private String title;

    /**
     * Le nom de l'auteur
     */
    private String author;

    /**
     * La langue du livre
     */
    private String language;

    /**
     * Le nombre de pages du livre
     */
    private int totalPages;

    /**
     * La durée d'un emprunt du livre
     */
    private int loanPeriod;

    /**
     * Le prix d'un emprunt du livre
     */
    private int rentalPrice;

    /**
     * L'emprunteur du livre
     */
    private Person borrower;

    /**
     * La date d'emprunt du livre
     */
    public LocalDate borrowingDate;

    /**
     * Crée un livre et définit son type
     *
     * @param 	title Le titre du livre
     * @param   author L'auteur
     * @param 	totalPages Le nombre de pages total
     * @param 	loanPeriod La durée d'un prêt
     * @param 	rentalPrice Le prix de location
     * @param 	language La langue du livre
     */
    
    public Book (String title, String author, int totalPages, int loanPeriod, int rentalPrice, String language) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.loanPeriod = loanPeriod;
        this.rentalPrice = rentalPrice;
        this.language = language;
    }

    /**
     * Crée un livre vierge
     */
    Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.borrower = null;
        this.totalPages = 0;
        this.loanPeriod = 0;
        this.rentalPrice = 0;
        this.language = "Unknown language";
    }


    /**
     * @return Descriptif d'un livre
     */
    @Override
    public String toString() {
        return "Titre : " + this.title + " Auteur : " + this.author + "Emprunteur : " + this.borrower + " Nombre de pages : " + this.totalPages + " Loan Period : " + this.loanPeriod + " Coût : " + this.rentalPrice + " Date d'emprunt : " + this.borrowingDate.toString() + " Langue : " + this.language;
    }


    /**
     * Modifie le titre du livre
     *
     * @param title Le nouveau titre du livre
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Renvoie le titre du livre
     *
     * @return Le titre du livre
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifie l'auteur du livre
     *
     * @param author Le nouvel auteur du livre
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Renvoie l'auteur du livre
     *
      * @return L'auteur du livre
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Modifie l'emprunteur du livre
     *
     * @param borrower Le nouvel emprunteur du livre
     */
    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        this.borrowingDate = LocalDate.now();
    }

    /**
     * Renvoie l'emprunteur du livre
     *
     * @return L'emprunteur du livre
     */
    public Person getBorrower() {
        return borrower;
    }

    /**
     * Modifie le nombre de pages total du livre
     *
     * @param totalPages Le nouveau nombre de pages total du livre
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }


    /**
     * Renvoie le nombre de pages du livre
     *
     * @return Le nombre total de pages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Modifie le prix d'emprunt du livre
     *
     * @param rentalPrice Le nouveu prix de l'emprunt
     */
    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    /**
     * Renvoie le prix d'emprunt du livre
     *
     * @return Le prix d'emprunt
     */
    public int getRentalPrice() {
        return rentalPrice;
    }

    /**
     * Modifie la période de prêt du livre
     *
     * @param loanPeriod La nouvelle période de prêt du livre
     */
    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    /**
     * Renvoie la période d'un prêt du livre
     *
     * @return La durée d'un emprunt
     */
    public int getLoanPeriod() {
        return loanPeriod;
    }

    /**
     * Modifie la langue du livre
     *
     * @param language La nouvelle langue du livre
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Renvoie le langue du livre
     *
     * @return La langue du livre
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Calcule la difference de jours entre la date d'emprunt et la date actuelle
     *
     * @return La difference de jours
     */
    public Integer computeRemainingDays() {
        return borrowingDate.plusDays((long)this.loanPeriod).compareTo(LocalDate.now());
    }
}
