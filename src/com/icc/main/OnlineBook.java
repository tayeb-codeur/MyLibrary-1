package com.icc.main;

/**
 * Définit le type de livre en ligne
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1 (24.03.21)
 */

import java.util.Date;

public class OnlineBook extends Book{
    private int maxPeople;
    private String content;
    
    /**
     * Crée un livre en ligne
     * 
     * @param 	maxPeople - nom d'emprunteurs maximum
     * 			content - / / / / / / / / / / / BESOIN D'AJOUT DE LA DOCUMENTATION / / / / / / / / / / /  
     * 
     *  + tous les attributs de la classe mère Book
     *  		title - Le titre du livre
     * 			author - l'auteur
     * 			person - la personne qui a emprunté le livre
     * 			totalPages - le nombre de pages total
     * 			loanPeriod - période de prêt
     * 			rentalPrice - prix de location
     * 			borrowinDate - date l'emprunt
     * 			language - langue du livre
     *  @throws ToDo éventuellement ################################################
     */

    OnlineBook(String title, String author, Person person, int totalPages, int loanPeriod, int rentalPrice, Date borrowingDate, String language, int maxPeople, String content){
        super(title, author, person, totalPages, loanPeriod, rentalPrice, borrowingDate, language);
        this.maxPeople = maxPeople;
        this.content = content;
    }

    /**
     * Crée un livre en ligne et laisse libre champs à l'utilisateur
     */
    OnlineBook() {
        super();
        this.maxPeople = 0;
        this.content = "Unknown";
    }

    /**
     * Modifie le / / / / / / / / / / / BESOIN D'AJOUT DE LA DOCUMENTATION / / / / / / / / / / /
     * @param Content / / / / / / / / / / / / BESOIN D'AJOUT DE LA DOCUMENTATION / / / / / / / / / / /
     * @throws ToDo éventuellement ################################################
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    
    // PAS DE getContent ??   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    

    /**
     * Modifie le nombre d'emprunteurs maximum
     * @param MaxPeople / le nombre d'emprunteurs maximum
     */
    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
    
    // PAS DE getMaxPeople ??   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
}
