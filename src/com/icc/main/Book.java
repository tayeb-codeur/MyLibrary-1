package com.icc.main;

/**
 * Définit le type de livre
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1 (24.03.21)
 */

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

    /**
     * Crée un livre et définit son type
     * 
     * @param 	title - Le titre du livre
     * 			author - l'auteur
     * 			person - la personne qui a emprunté le livre
     * 			totalPages - le nombre de pages total
     * 			loanPeriod - période de prêt
     * 			rentalPrice - prix de location
     * 			borrowinDate - date l'emprunt
     * 			language - langue du livre
     *  @throws ToDo éventuellement ################################################
     */
    
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

    /**
     * Crée un livre et laisse libre champs à l'utilisateur
     */
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


    /**
     * @return toString de la classe Book
     */
    @Override
    public String toString() {
        return "Titre : " + this.title + " Auteur : " + this.author + "Emprunteur : " + this.person + " Nombre de pages : " + this.totalPages + " Loan Period : " + this.loanPeriod + " Coût : " + this.rentalPrice + " Date d'emprunt : " + this.borrowingDate.toString() + " Langue : " + this.language;
    }


    /**
     * Modifie le titre du livre 
     * @param Title / Le nouveau titre du livre
     * @throws ToDo éventuellement ################################################
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
     * @throws ToDo éventuellement ################################################
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    
    // PAS DE getAuthor ??   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    
    
    

    /**
     * Modifie le locataire du livre 
     * @param person / Le nouveau locataire du livre
     * @throws ToDo éventuellement ################################################
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Renvoi le locataire du livre
     * @return le locataire du livre
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Modifie le nombre de pages total du livre 
     * @param TotalPages / Le nouveau nombre de pages totales du livre
     * @throws ToDo éventuellement ################################################
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    
    
    // PAS DE getTotalPages ??  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    
    
    
    /**
     * Modifie le prix de location du livre
     * @param RentalPrice / Le nouveu prix de location
     * @throws ToDo éventuellement ################################################
     */
    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    
    // PAS DE getRentalPrice ??  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    
    
    /**
     * Modifie la période de prêt du livre
     * @param LoanPeriod / La nouvelle période de prêt du livre
     * @throws ToDo éventuellement ################################################
     */
    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }
    
    
    // PAS DE getLoanPeriod ??  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

    
    /**
     * Modifie la date de l'emprunt
     * @param BorrowingDate / La nouvelle date de l'emprunt du livre
     * @throws ToDo éventuellement ################################################
     */
    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    
    /**
     * Renvoi la date de l'emprunt du livre
     * @return la date de l'emprunt du livre
     */
    public Date getBorrowingDate() {
        return borrowingDate;
    }

    /**
     * Modifie la langue du livre
     * @param Language / La nouvelle langue du livre
     * @throws ToDo éventuellement ################################################
     */
    public void setLanguage(String language) {
        this.language = language;
    }
    
    // PAS DE getLanguage ??  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    
   
}
