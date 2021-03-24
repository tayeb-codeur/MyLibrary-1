package com.icc.main;

/**
 * Définit le type de bande dessinée
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1 (24.03.21)
 */

import java.util.Date;

public class GraphicNovel extends Book{
    private String cartoonist;
    private boolean color;
    
    /**
     * Crée une bande déssinée
     * 
     * @param 	cartoonist - le nom du dessinateur
     * 			color - couleur ou noir et blanc  
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

    GraphicNovel(String title, String author, Person person, int totalPages, int loanPeriod, int rentalPrice, Date borrowingDate, String language, String cartoonist, boolean color){
        super(title, author, person, totalPages, loanPeriod, rentalPrice, borrowingDate, language);
        this.cartoonist = cartoonist;
        this.color = color;
    }

    /**
     * Crée une bande dessinée et laisse libre champs à l'utilisateur
     */
    GraphicNovel() {
        super();
        this.cartoonist = "Cartoonist";
        this.color = false;
    }

    /**
     * Modifie le nom du dessinateur
     * @param Cartoonist / le nom du dessinateur
     * @throws ToDo éventuellement ################################################
     */
    public void setCartoonist(String cartoonist) {
        this.cartoonist = cartoonist;
    }
    
    // PAS DE getCartoonist ??   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

    /**
     * Modifie bande dessinée couleur ou non
     * @param Color / bande dessinée couleur ou non
     * @throws ToDo éventuellement ################################################
     */
    public void setColor(boolean color) {
        this.color = color;
    }
    
    // PAS DE getColor ??   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

}
