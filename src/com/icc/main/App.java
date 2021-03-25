package com.icc.main;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MyLibrary myLibrary = new MyLibrary("BiblioICC");
        int choix = 5;

        while (choix != 0) {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Ajouter un membre");
            System.out.println("2. Ajouter un livre");
            System.out.println("3. Emprunter un livre");
            System.out.println("4. Voir les statistiques");
            System.out.println("0. Quitter le programme");

            try {
                choix = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre !");
            }

            switch (choix) {
                case 1:
                    System.out.println("===== NOUVEAU MEMBRE =====");
                    Person tmpPerson = new Person();
                    System.out.println("Quel est le nom du membre ?");
                    tmpPerson.setName(sc.nextLine());
                    System.out.println("Combien de livres le membre peut-il emprunter ?");

                    try {
                        tmpPerson.setMaxBooks(Byte.parseByte(sc.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("La valeur entrée est invalide !");
                    }

                    myLibrary.addPerson(tmpPerson);
                    System.out.println("Le membre " + tmpPerson.getName() + " pouvant emprunter " + tmpPerson.getMaxBooks() + " livres a été créé !");

                    break;
                case 2:
                    System.out.println("===== NOUVEAU LIVRE =====");
                    break;
                case 3:
                    System.out.println("===== NOUVEL EMPRUNT =====");

                    String inputBook, inputMember;
                    int idBook = 0, idMember = 0;

                    System.out.println("Quel est le livre à emprunter (0 pour annuler) ?");
                    inputBook = sc.nextLine();

                    if (inputBook == "0") break;

                    for (Book b : myLibrary.getBooks()) {
                        if (b.getTitle().contains(inputBook)) {
                            if (b.getBorrower() != null) {
                                System.out.println(myLibrary.getBooks().indexOf(b) + ". " + b.getTitle() + " - DISPO");
                            } else {
                                System.out.println(b.getTitle() + " - NON DISPO");
                            }
                        }
                    }

                    System.out.println("Donnez l'ID du livre à emprunter (0 pour annuler)");

                    try {
                        idBook = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez entrer une valeur correcte !");
                    }

                    if (idBook == 0) break;

                    System.out.println("Quel est le nom de l'emprunteur (0 pour annuler) ?");
                    inputMember = sc.nextLine();

                    if (inputMember == "0") break;

                    for (Person p : myLibrary.getPeople()) {
                        if (p.getName().contains(inputMember)) {
                            if (p.getBooks().size() < p.getMaxBooks()) {
                                System.out.println(myLibrary.getPeople().indexOf(p) + ". " + p.getName() + " - PEUT EMPRUNTER");
                            } else {
                                System.out.println(p.getName() + " - NE PEUT PLUS EMPRUNTER");
                            }
                        }
                    }

                    System.out.println("Donnez l'ID du membre emprunteur (0 pour annuler)");

                    try {
                        idMember = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez entrer une valeur correcte !");
                    }

                    if (idMember == 0) break;

                    myLibrary.getBooks().get(idBook).setBorrower(myLibrary.getPeople().get(idMember));
                    myLibrary.getPeople().get(idMember).getBooks().add(myLibrary.getBooks().get(idBook));

                    System.out.println("Le livre " + myLibrary.getBooks().get(idBook).getTitle() + " doit être retourné pour le " + myLibrary.getBooks().get(idBook).borrowingDate.plusDays(myLibrary.getBooks().get(idBook).getLoanPeriod()).toString());
                    System.out.println("SYNTHESE : " + myLibrary.getPeople().get(idMember).getName() + " emprunte le livre " + myLibrary.getBooks().get(idBook).getTitle() + " et doit le retourner pour le " + myLibrary.getBooks().get(idBook).borrowingDate.plusDays(myLibrary.getBooks().get(idBook).getLoanPeriod()).toString());

                    break;
                case 4:
                    System.out.println("===== STATISTIQUES =====");

                    int nbrBooks = 0, nbrGraphicNovels =0, nbrOnlineBooks = 0, nbrMembers = 0, nbrBorrowingMembers = 0, nbrBorrowedBooks = 0, nbrLateBooks = 0;

                    nbrBooks = myLibrary.getBooks().size();
                    nbrMembers = myLibrary.getPeople().size();

                    for (Book b : myLibrary.getBooks()) {
                        if (b instanceof OnlineBook) {
                            nbrOnlineBooks++;
                        } else if (b instanceof GraphicNovel) {
                            nbrGraphicNovels++;
                        }

                        if (b.getBorrower() != null) nbrBorrowedBooks++;

                        if (b.computeRemainingDays() > 0) nbrLateBooks++;
                    }

                    for (Person p : myLibrary.getPeople()) {
                        if (p.getBooks().size() > 0) nbrBorrowingMembers++;
                    }

                    System.out.println("Nombre de livres : " + nbrBooks + " (Livres electroniques : " + nbrOnlineBooks + "/ Romans Graphiques : " + nbrGraphicNovels + ") / Nombre de membres : " + nbrMembers + "( Emprunteurs : " + nbrBorrowingMembers + ")");
                    System.out.println("Nombre de livres empruntés " + nbrBorrowedBooks);
                    System.out.println("Nombre de livres en retard : " + nbrLateBooks);

                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                    break;
                default:

            }
        }
    }
}
