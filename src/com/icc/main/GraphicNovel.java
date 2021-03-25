package com.icc.main;

/**
 * Définit le type de Roman Graphique
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1
 */


public class GraphicNovel extends Book{
    /**
     * Le nom du dessinateur du roman graphique
     */
    private String cartoonist;

    /**
     * La présence ou non de couleurs
     */
    private boolean color;
    
    /**
     * Crée un roman graphique
     *
     * @param 	title Le titre du livre
     * @param   author L'auteur
     * @param 	totalPages Le nombre de pages total
     * @param 	loanPeriod La durée d'un prêt
     * @param 	rentalPrice Le prix de location
     * @param 	language La langue du livre
     * @param 	cartoonist Le nom du dessinateur
     * @param   color Le livre est-il en couleurs ?
     */

    GraphicNovel(String title, String author, int totalPages, int loanPeriod, int rentalPrice, String language, String cartoonist, boolean color){
        super(title, author, totalPages, loanPeriod, rentalPrice, language);
        this.cartoonist = cartoonist;
        this.color = color;
    }

    /**
     * Crée une bande dessinée vierge
     */
    GraphicNovel() {
        super();
        this.cartoonist = "Cartoonist";
        this.color = false;
    }

    /**
     * Modifie le nom du dessinateur
     *
     * @param cartoonist Le nom du dessinateur
     */
    public void setCartoonist(String cartoonist) {
        this.cartoonist = cartoonist;
    }

    /**
     * Renvoie le nom du dessinateur
     *
     * @return Le nom du dessinateur
     */
    public String getCartoonist() {
        return cartoonist;
    }

    /**
     * Modifie la présence ou non de couleurs dans le livre
     *
     * @param color La présence de couleurs
     */
    public void setColor(boolean color) {
        this.color = color;
    }

    /**
     * Renvoie la présence ou non de couleurs
     *
     * @return La présence de couleurs
     */
    public Boolean getColor() {
        return color;
    }

}
