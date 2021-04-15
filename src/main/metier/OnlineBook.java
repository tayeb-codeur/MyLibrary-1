package main.metier;

/**
 * Définit le type de Livre Numérique
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1
 */


public class OnlineBook extends Book {

    /**
     * Le nombre maximum d'emprunteurs
     */
    private int maxPeople;

    /**
     * Le contenu du livre numérique
     */
    private String content;
    
    /**
     * Crée un livre numérique
     *
     * @param 	title Le titre du livre
     * @param   author L'auteur
     * @param 	totalPages Le nombre de pages total
     * @param 	loanPeriod La durée d'un prêt
     * @param 	rentalPrice Le prix de location
     * @param 	language La langue du livre
     * @param 	maxPeople Nom d'emprunteurs maximum de l'e-Book
     * @param   content Le contenu du livre numérique
     */

    OnlineBook(String title, String author, int totalPages, int loanPeriod, int rentalPrice, String language, int maxPeople, String content){
        super(title, author, totalPages, loanPeriod, rentalPrice, language);
        this.maxPeople = maxPeople;
        this.content = content;
    }

    /**
     * Créé un e-Book vierge
     */
    public OnlineBook() {
        super();
        this.maxPeople = 0;
        this.content = "Unknown";
    }

    /**
     * Modifie le contenu de l'e-Book
     * @param content Le contenu de l'e-Book
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Renvoie le contenu de l'e-Book
     *
     * @return Le contenu de l'e-Book
     */
    public String getContent() {
        return content;
    }

    /**
     * Modifie le nombre d'emprunteurs maximum
     * @param maxPeople Le nombre d'emprunteurs maximum
     */
    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    /**
     * Renvoie le nombre d'emprunteurs maximum
     *
     * @return Le nombre maximum d'emprunteurs
     */
    public int getMaxPeople() {
        return maxPeople;
    }
}
