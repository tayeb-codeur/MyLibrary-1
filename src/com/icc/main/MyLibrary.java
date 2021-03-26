package com.icc.main;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.StringTokenizer;


/**
 * Représente la bibliothèque
 * Définie par son nom, la liste des membres et la liste des livres.
 *
 * @author C. Ruth
 * @version 0.1
 * @see Book
 * @see Person
 */
public class MyLibrary {
    /**
     * Nom de la bibliothèque
     */
    private String name;

    /**
     * Liste des livres
     */
    private ArrayList<Book> books;

    /**
     * Liste des membres
     */
    private ArrayList<Person> people;

    /**
     * Crée une bibliothèque en spécifiant son nom
     *
     * @param name Nom de la bibliothèque
     */
    public MyLibrary(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
        this.people = new ArrayList<Person>();
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

    /**
     * Recupère les membres contenus dans un fichier CSV
     *
     * @param filename Le chemin du fichier CSV
     * @return Le nombre de membres récupérés
     */
    public int loadMembers(String filename) {
        int cpt = 0;

        File f = new File(filename);

        if(f.exists()) {
            FileReader fr = null;
            BufferedReader br = null;
            String[] data = null;

            try {
                try {
                    fr = new FileReader(f);
                    br = new BufferedReader(fr);

                    //Convertir en objet Person
                    //StringTokenizer st = new StringTokenizer(ligne, ";");
                    String ligne = br.readLine();

                    //Lire une ligne du fichier
                    while ((ligne = br.readLine()) != null) {
                        //"a7aa0ae7-9ce3-44bc-a72a-894edb9a4653;Bob Smith;2;01-03-20"
                        data = ligne.split(";");
                        Person p = new Person(UUID.fromString(data[0]), data[1]);

                        //ajouter cette Person dans people
                        this.people.add(p);
                        cpt++;
                    }
                } finally {
                    br.close();
                }
            } catch (IOException e) {

            }

            System.out.println(people);
        }

        return cpt;
    }

    /**
     * Recupère les livres contenus dans un fichier CSV
     *
     * @param filename Le chemin du fichier CSV
     * @return Le nombre de livres récupérés
     */
    public int loadBooks(String filename) {
        int cpt = 0;

        File f = new File(filename);

        if(f.exists()) {
            FileReader fr = null;
            BufferedReader br = null;
            String[] data = null;

            try {
                try {
                    fr = new FileReader(f);
                    br = new BufferedReader(fr);

                    //Convertir en objet Book
                    //StringTokenizer st = new StringTokenizer(ligne, ";");
                    String ligne = br.readLine();

                    //Lire une ligne du fichier
                    while ((ligne = br.readLine()) != null) {

                        data = ligne.split(";");
                        Book b = new Book(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5]);

                        //ajouter ce Book dans books
                        this.books.add(b);
                        cpt++;
                    }
                } finally {
                    br.close();
                }
            } catch (IOException e) {

            }

            System.out.println(books);
        }

        return cpt;
    }

    /**
     * Ecrit un fichier CSV contenant les membres de la bibliothèques
     *
     * @param filename Le chemin du fichier
     */
    public void saveMembers(String filename) {
        File f = new File(filename);

            FileWriter fw = null;
            BufferedWriter bw = null;

            try {
                try {
                    fw = new FileWriter(f);
                    bw = new BufferedWriter(fw);

                    for (Person p : people) {
                        bw.write(p.getId().toString() + ";" + p.getName());
                        bw.newLine();
                    }

                } finally {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("IOException pour people");
            }

    }




    /**
     * Ecrit un fichier CSV contenant les livres de la bibliothèque
     *
     * @param filename Le chemin du fichier
     */
    public void saveBooks(String filename) {
        File f = new File(filename);

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            try {
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);

                for (Book b : books) {
                    bw.write(b.getTitle() + ";" + b.getAuthor() + ";" + b.getTotalPages() + ";" + b.getLoanPeriod() + ";" + b.getRentalPrice() + ";" + b.getLanguage());
                    bw.newLine();
                }

            } finally {
                bw.close();
            }

        } catch (IOException e) {

        }


    }


}


