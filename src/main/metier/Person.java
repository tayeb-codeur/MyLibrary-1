package main.metier;

import main.metier.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Définit la classe Person (un membre de la bibliothèque)
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1 (24.03.21)
 */

public class Person {
    /**
     * ID du membre
     */
    protected UUID id;

    /**
     * Nom du membre
     */
    private String name;

    /**
     *
     * Nombre maximum de livres empruntables par le membre
     */
    private byte maxBooks;

    /**
     * Date d'inscription du membre
     */
    private LocalDate registrationDate;

    /**
     * Liste des livres empruntés par le membre
     */
    private ArrayList<Book> books;


    /**
     * Crée un membre en spécifiant son nom et son ID
     * @param id L'ID du membre
     * @param name Le nom du membre
     */
    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.maxBooks = 3;
        this.registrationDate = LocalDate.now();
        this.books = new ArrayList<Book>();
    }

    /**
     * Crée un membre inconnu à l'ID généré aléatoirement
     */
    public Person() {
        this.id = UUID.randomUUID();
        this.name = "Inconnu";
        this.maxBooks = 3;
        this.registrationDate = LocalDate.now();
        this.books = new ArrayList<Book>();
    }

    /**
     * Renvoie le nom du membre
     *
     * @return Le nom du membre
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom du membre
     *
     * @param name Le nom du membre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Renvoie le nombre de livres empruntables par le membre
     *
     * @return Le nombre max de livres empruntables
     */
    public byte getMaxBooks() {
        return maxBooks;
    }

    /**
     * Modifie le nombre maximum de livres empruntables
     *
     * @param maxBooks Le nombre maximum de livres empruntables
     */
    public void setMaxBooks(byte maxBooks) {
        this.maxBooks = maxBooks;
    }

    /**
     * Renvoie l'ID du membre
     *
     * @return l'ID du membre
     */
    public UUID getId() {
        return id;
    }

    /**
     * Modifie l'ID du membre
     *
     * @param id l'ID du membre
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Renvoie la date d'inscription du membre
     *
     * @return La date d'inscription
     */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Modifie la date d'inscription du membre
     *
     * @param registrationDate La date d'inscription
     */
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Renvoie la liste des livres empruntés par le membre
     *
     * @return La liste des livres empruntés
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Modifie la liste des livres empruntés par le membre
     *
     * @param books Une liste de livres à emprunter
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    /**
     * Renvoie le descriptif du membre sous la forme d'une chaine de caractère
     *
     * @return Le descriptif du membre
     */
    @Override
    public String toString() {
        final int maxLen = 3;
        return "Person [" + id + ": " + name + " (maxBooks=" + maxBooks + ", inscrit le "
                + registrationDate + ")\n books="
                + (books != null ? books.subList(0, Math.min(books.size(), maxLen)) : null) + "]";
    }

    /**
     * Ajoute un livre à la liste des livres empruntés par le membre et lui attribue la date d'emprunt actuelle
     *
     * @param book Le nouveau livre à ajouter à la liste
     */
    public void borrows(Book book) {
        this.books.add(book);
        book.setBorrower(this);
        book.borrowingDate = LocalDate.now();
    }

    /**
     * Retire un livre de la liste des livres empruntés par le membre
     *
     * @param book Le livre à retirer de la liste des livres
     */
    public void returns(Book book) {
        this.books.remove(book);
        book.setBorrower(null);
        book.borrowingDate = null;
    }

}

