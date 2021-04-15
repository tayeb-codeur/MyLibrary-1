package main.metier;

import main.dao.DaoLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;


/**
 * Représente la bibliothèque
 * Définie par son nom, la liste des membres et la liste des livres.
 *
 * @author C. Ruth
 * @version 0.1
 * @see Book
 * @see Person
 */
public class MyLibrary implements DaoLibrary {
    /**
     * Nom de la bibliothèque
     */
    private String name;

    /**
     * Liste des livres
     */
    private ArrayList<Book> books = new ArrayList<Book>();

    /**
     * Liste des membres
     */
    private ArrayList<Person> people = new ArrayList<Person>();

    /**
     * Crée une bibliothèque en spécifiant son nom
     *
     * @param name Nom de la bibliothèque
     */
    public MyLibrary(String name) {
        this.name = name;
    }

    /**
     * Renvoie le nom de la bibliothèque
     *
     * @return Le nom de la bibliothèque
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom de la bibliothèque
     *
     * @param name Nouveau nom de la bibliothèque
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Renvoie la liste des livres
     *
     * @return la liste des livres
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Modifie la liste des livres
     *
     * @param books Nouvelle liste des livres
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    /**
     * Renvoie la liste des membres
     *
     * @return la liste des membres
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Modifie la liste des membres
     *
     * @param people Nouvelle liste des membres
     */
    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    /**
     * Renvoie un descriptif du livre sous la forme d'une chaine de caractère
     *
     * @return La chaine de caractère contenant les informations du livre
     */
    @Override
    public String toString() {
        final int maxLen = 3;
        return "MyLibrary " + name + ": books="
                + (books != null ? books.subList(0, Math.min(books.size(), maxLen)) : null) + ", people="
                + (people != null ? people.subList(0, Math.min(people.size(), maxLen)) : null);
    }

    /**
     * Ajoute le livre à la liste des livres de la bibliothèque
     *
     * @param book Le livre à ajouter
     */
    public void addBook(Book book) {
        this.books.add(book);
    }

    /**
     * Ajoute un membre à la liste des membres de la bibliothèque
     *
     * @param person Le membre à ajouter
     */
    public void addPerson(Person person) {
        this.people.add(person);
    }

    /**
     * Liste les livres de la bibliothèque et renvoie leur nombre
     *
     * @return Le nombre de livres
     */
    public int printBooks() {
        int cpt = 0;

        Iterator<Book> it = this.getBooks().iterator();

        while(it.hasNext()) {
            Book b = it.next();

            System.out.println(++cpt + ": "
                    +b.getTitle() + " - "
                    +b.getAuthor());
        }
        return cpt;
    }

    /**
     * Liste les membres de la bibliothèque et renvoie leur nombre
     *
     * @return Le nombre de membres
     */
    public int printMembers() {
        int cpt = 0;

        Iterator<Person> itp = this.getPeople().iterator();

        while(itp.hasNext()) {
            Person p = itp.next();

            System.out.println(++cpt + ": " + p.getName());
        }
        return cpt;
    }

}


