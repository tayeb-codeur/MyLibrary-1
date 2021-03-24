package com.icc.main;

/**
 * Définit le type d'emprunteur
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1 (24.03.21)
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Person {
    private String name;
    private int maxBooks;
    private Date registrationDate;
    
    /**
     * Crée un emprunteur
     * 
     * @param 	name - nom de l'emprunteur
     * 			maxBooks - nombnre maximum de livres pouvant être empruntés
     * 			registrationDate - date de l'inscription
     *  @throws ToDo éventuellement ################################################
     */

    Person (String name, int maxBooks) {
        this.name = name;
        this.maxBooks = maxBooks;
        this.registrationDate = new Date(System.currentTimeMillis());
    }

    /**
     * Crée un emprunteur et laisse libre champs à l'utilisateur
     */
    Person() {
        this.name = "Unknown";
        this.maxBooks = 5;
        this.registrationDate = new Date(System.currentTimeMillis());
    }

    /**
     * @return toString de la classe Person
     */
    @Override
    public String toString() {
        return "Nom : " + this.name + " | Livres empruntables : " + this.maxBooks + " | Date d'enregistrement : " + this.registrationDate;
    }

    /**
     * Modifie le nom de l'emprunteur
     * @param Name / Le nouveau nom de l'emprunteur
     * @throws ToDo éventuellement ################################################
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Renvoi le nom de l'emprunteur
     * @return le nom de l'emprunteur
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nombre maximum de livres pouvant être empruntés 
     * @param MaxBooks / Le nouveau nombre maximum de livres pouvant être empruntés 
     * @throws ToDo éventuellement ################################################
     */
    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    /**
     * Renvoi le nombre maximum de livres pouvant être empruntés 
     * @return le nombre maximum de livres pouvant être empruntés 
     */
    public int getMaxBooks() {
        return maxBooks;
    }
    
    // PAS DE setMaxBooks ??  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

    /**
     * Renvoi le nombre la date de l'inscription
     * @return le nombre la date de l'inscription
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }
    
    // PAS DE setRegistratioDate ??  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
}
