package com.icc.main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int choix = 5;

        System.out.println("Bienvenue dans l'application MyLibrary");

        MyLibrary myLibrary = new MyLibrary();

        while (choix != 0) {
            myLibrary.showMenu();

            choix = Integer.parseInt(sc.nextLine());

            if (choix <= 4 && choix >= 0) {
                switch (choix) {
                    case 0 :
                        sc.close();
                        System.exit(0);
                        break;
                    case 1 :
                        myLibrary.addMember(sc);
                        break;
                    case 2 :
                        myLibrary.addBook(sc);
                        break;
                    case 3 :
                        myLibrary.borrowBook(sc);
                        break;
                    case 4 :
                        myLibrary.showStats();
                        break;
                    default:

                }
            } else System.out.println("Veuilliez entrer un choix valide !");
        }



    }
}