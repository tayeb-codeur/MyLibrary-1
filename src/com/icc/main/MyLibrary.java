package com.icc.main;

/**
 * Définit les méthodes de l'algorithme
 * @author Antoine Dieudonné / Ludovic Marigliano
 * @Version 0.1 (24.03.21)
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

	/**
	 * Contient les méthodes de l'algorithme
	 * 
	 * @param 	name - / / / / / / / / / / / BESOIN D'AJOUT DE LA DOCUMENTATION / / / / / / / / / / / 
	 * 			Arraylist books - liste des livres
	 * 			Arraylist peoples - liste des emprunteurs 
	 * 
	 *  @throws ToDo éventuellement ################################################
	 */
	
	public class MyLibrary {
	    private String name;
	    private ArrayList<Book> books = new ArrayList<>();
	    private ArrayList<Person> peoples = new ArrayList<Person>();
    
	    
    /**
     * Affiche le menu 
     */

    public void showMenu() {
        System.out.println("----------MENU PRINCIPAL----------");
        System.out.println("1. Ajouter un Membre");
        System.out.println("2. Ajouter un Livre");
        System.out.println("3. Emprunter un livre");
        System.out.println("4. Voir les Statistiques de la Bibliothèque");
        System.out.println("0. Quitter");
    }
    
    /**
     * Ajoute un membre
     * @param Scanner sc / récupère l'entrée au clavier
     * @throws ToDo # # # # # # # # # # # # # # # # # # # # # #  # # #  # # #  #
     */

    public void addMember(Scanner sc) throws Exception {
        System.out.println("----------AJOUTER UN MEMBRE----------");
        Person tmpPerson = new Person();
        System.out.println("Quel est son Nom ?");
        tmpPerson.setName(sc.nextLine());
        System.out.println("Combien de livres peut-il(elle) emprunter ?");
        tmpPerson.setMaxBooks(Integer.parseInt(sc.nextLine()));

        peoples.add(tmpPerson);
        System.out.println("Le membre " + tmpPerson.toString() + " a été créé !");
    }
    
    /**
     * Ajoute un livre en fonction de son type
     * @param 	Scanner sc / récupère l'entrée au clavier
     * 			
     * @throws ToDo # # # # # # # # # # # # # # # # # # # # # #  # # #  # # #  #
     */

    public void addBook(Scanner sc) throws Exception {
        System.out.println("----------AJOUTER UN LIVRE----------");
        System.out.println("De quel genre de livre s'agit-il ?");
        System.out.println("1. Livre standard");
        System.out.println("2. Livre Numérique");
        System.out.println("3. Roman Graphique");

        int bookType = 0;

        while (bookType <0 || bookType > 3) {
            try {
                bookType = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 3 !");
            } finally {
                switch (bookType) {
                    case 1:
                        Book tmpBook = new Book();
                        System.out.println("Quel est le titre du livre ?");
                        tmpBook.setTitle(sc.nextLine());
                        System.out.println("Qui est l'auteur du livre ?");
                        tmpBook.setAuthor(sc.nextLine());
                        System.out.println("Combien de page compte le livre ?");
                        tmpBook.setTotalPages(Integer.parseInt(sc.nextLine()));
                        System.out.println("En quel langue est le livre ?");
                        tmpBook.setLanguage(sc.nextLine());

                        System.out.println("Quelle est la durée d'un emprunt ?");
                        tmpBook.setLoanPeriod(Integer.parseInt(sc.nextLine()));
                        System.out.println("Quel est le coût de l'emprunt ?");
                        tmpBook.setRentalPrice(Integer.parseInt(sc.nextLine()));

                        books.add(tmpBook);

                        break;
                    case 2:
                        OnlineBook tmpOnlineBook = new OnlineBook();
                        System.out.println("Quel est le titre du livre ?");
                        tmpOnlineBook.setTitle(sc.nextLine());
                        System.out.println("Qui est l'auteur du livre ?");
                        tmpOnlineBook.setAuthor(sc.nextLine());
                        System.out.println("Combien de page compte le livre ?");
                        tmpOnlineBook.setTotalPages(Integer.parseInt(sc.nextLine()));
                        System.out.println("En quel langue est le livre ?");
                        tmpOnlineBook.setLanguage(sc.nextLine());
                        System.out.println("Quel est le contenu du livre ?");
                        tmpOnlineBook.setContent(sc.nextLine());

                        System.out.println("Quelle est la durée d'un emprunt ?");
                        tmpOnlineBook.setLoanPeriod(Integer.parseInt(sc.nextLine()));
                        System.out.println("Quel est le coût de l'emprunt ?");
                        tmpOnlineBook.setRentalPrice(Integer.parseInt(sc.nextLine()));
                        System.out.println("Combien d'individus peuvent emprunter le livre ?");
                        tmpOnlineBook.setMaxPeople(Integer.parseInt(sc.nextLine()));

                        books.add(tmpOnlineBook);

                        break;
                    case 3:
                        GraphicNovel tmpGraphicNovel = new GraphicNovel();
                        System.out.println("Quel est le titre du livre ?");
                        tmpGraphicNovel.setTitle(sc.nextLine());
                        System.out.println("Qui est l'auteur du livre ?");
                        tmpGraphicNovel.setAuthor(sc.nextLine());
                        System.out.println("Qui est le dessinateur du livre ?");
                        tmpGraphicNovel.setCartoonist(sc.nextLine());
                        System.out.println("Combien de page compte le livre ?");
                        tmpGraphicNovel.setTotalPages(Integer.parseInt(sc.nextLine()));
                        System.out.println("En quel langue est le livre ?");
                        tmpGraphicNovel.setLanguage(sc.nextLine());
                        System.out.println("Le livre est-il en couleur ? (O/N)");
                        tmpGraphicNovel.setColor(Boolean.parseBoolean(sc.nextLine()));

                        System.out.println("Quelle est la durée d'un emprunt ?");
                        tmpGraphicNovel.setLoanPeriod(Integer.parseInt(sc.nextLine()));
                        System.out.println("Quel est le coût de l'emprunt ?");
                        tmpGraphicNovel.setRentalPrice(Integer.parseInt(sc.nextLine()));

                        books.add(tmpGraphicNovel);

                        break;
                    default:

                }
            }

        }



    }

    
    /**
     * Enregistre l'emprunt d'un livre par un emprunteur
     * 			
     * @throws ToDo # # # # # # # # # # # # # # # # # # # # # #  # # #  # # #  #
     */
    public void borrowBook(Scanner sc){
        String inputBorrower;
        String inputBook;

        System.out.println("----------EMPRUNTER UN LIVRE----------");
        System.out.println("Quel est le livre à emprunter ?");
        inputBook = sc.nextLine();
        System.out.println("Qui emprunte le livre ?");
        inputBorrower = sc.nextLine();

        for (Book b : books) {
            if (b.getTitle() == inputBook) {
                for (Person p : peoples) {
                    if (p.getName() == inputBorrower) {
                        b.setPerson(p);
                        b.setBorrowingDate(new Date(System.currentTimeMillis()));
                    }
                }
            }
        }

    }

    /**
     * Affiche les statistiques / Liste des membres - Liste des livres - Emprunts en cours
     * 			
     * @throws ToDo # # # # # # # # # # # # # # # # # # # # # #  # # #  # # #  #
     */
    public void showStats(){
        System.out.println("----------STATISTIQUES DE LA BIBLIOTHEQUE----------");
        System.out.println("1. Liste des Membres");
        for (Person p : peoples) System.out.println(p.toString());
        System.out.println("2. Liste des Livres");
        for (Book b : books) System.out.println(b.toString());
        System.out.println("3. Emprunts en cours");
        for (Book b : books) {
            if (b.getPerson() != null) {
                System.out.println(b.getTitle() + " a été emprunté le " + b.getBorrowingDate().toString() + " par " + b.getPerson().toString());
            }
        }
    }
}
