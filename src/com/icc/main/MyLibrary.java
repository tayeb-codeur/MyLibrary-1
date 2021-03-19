package com.icc.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MyLibrary {
    private String name;
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Person> peoples = new ArrayList<Person>();

    public void showMenu() {
        System.out.println("----------MENU PRINCIPAL----------");
        System.out.println("1. Ajouter un Membre");
        System.out.println("2. Ajouter un Livre");
        System.out.println("3. Emprunter un livre");
        System.out.println("4. Voir les Statistiques de la Bibliothèque");
        System.out.println("0. Quitter");
    }

    public void addMember(Scanner sc) {
        System.out.println("----------AJOUTER UN MEMBRE----------");
        Person tmpPerson = new Person();
        System.out.println("Quel est son Nom ?");
        tmpPerson.setName(sc.nextLine());
        System.out.println("Combien de livres peut-il(elle) emprunter ?");
        tmpPerson.setMaxBooks(Integer.parseInt(sc.nextLine()));
        System.out.println("Quelle est la date de son enregistrement ?");
        tmpPerson.setRegistrationDate(new Date(System.currentTimeMillis()));

        peoples.add(tmpPerson);
    }

    public void addBook(Scanner sc){
        System.out.println("----------AJOUTER UN LIVRE----------");
        System.out.println("De quel genre de livre s'agit-il ?");
        System.out.println("1. Livre standard");
        System.out.println("2. Livre Numérique");
        System.out.println("3. Roman Graphique");

    }

    public void borrowBook(Scanner sc){
        System.out.println("----------EMPRUNTER UN LIVRE----------");
    }

    public void showStats(){
        System.out.println("----------STATISTIQUES DE LA BIBLIOTHEQUE----------");
        System.out.println("1. Liste des Membres");
        System.out.println("2. Liste des Livres");
        System.out.println("3. Emprunts en cours");
    }
}
