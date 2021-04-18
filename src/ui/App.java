package ui;

import Metier.*;
import DaoLibrary.*;
import DaoLibrary.GraphicNovel;
import DaoLibrary.OnlineBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class App {

	public void loadLibrary(MyLibrary myLibrary) {
		System.out.println("Chargement de la bibliothèque...");
		/*
		 * System.out.println(myLibrary.loadBooks("data/books.csv",
		 * myLibrary.getBooks()) + " livres chargés...");
		 * System.out.println(myLibrary.loadMembers("data/members.csv",
		 * myLibrary.getPeople()) + " membres chargés...");
		 */
		System.out.println(myLibrary.toString());
	}

	public void menuPrincipal() {
		System.out.println("\t\t\t\t\t\t***** MENU PRINCIPAL *****");
		System.out.println("1. Ajouter un membre - 2. Ajouter un livre - 3. Emprunter un livre - "
				+ " 4. Voir les statistiques - 0. Quitter le programme");
		System.out.println(
				"*************************************************************************************************************************");
	}

	public void menuLivre() {
		System.out.println(
				"*************************************************************************************************************************");
		System.out.println("===== NOUVEAU LIVRE =====");
		System.out.println("1. Livre standard");
		System.out.println("2. Livre Numérique");
		System.out.println("3. Roman Graphique");
		System.out.println(
				"*************************************************************************************************************************");
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		MyLibrary myLibrary = new MyLibrary("BiblioICC");

		// variables pour le choix entre par utilisateur
		int choixMenu = 0;
		String nouveauMembre = null;
		int nbMax = 0;
		int choixLivre = 0;

		App app = new App();
		// app.loadLibrary(myLibrary);
		app.menuPrincipal();

		try {
			choixMenu = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Veuillez entrer une valeur valide !");
		}
		while (choixMenu != 0) {

			switch (choixMenu) {
			////////////////////////////////////////////// Ajout un membre//////////////////////////////////////////////////////
			case 1:
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("===== NOUVEAU MEMBRE =====");
				System.out.print("Entrer le nom du membre : ");
				nouveauMembre = sc.next();
				// UUID.randomUUID() generé un identifiant automatique
				Person tmpPerson = new Person(UUID.randomUUID(), nouveauMembre);

				System.out.print("Nombre de livres maximum que le membre peut emprunter : ");
				try {
					nbMax = sc.nextInt();
				} catch (Exception e) {
					System.out.println("La valeur entrée est invalide !");
				}
				tmpPerson.setMaxBooks(nbMax);
				myLibrary.addPerson(tmpPerson);
				// System.out.print("\033\143");
				app.loadLibrary(myLibrary);
				System.out.println();
				System.out.println(myLibrary.printMembers());
				System.out.println();
				// ajout des methode finPeople dans la class MyLibrary et edité la class App
				// pour tester toutes les methodes "
				System.out.print(" Entrer le nom  de  la personne a rechercher : ");
				String personRecherche = sc.next();
				if (myLibrary.findPeople(personRecherche).getName() != null)
					System.out.println(personRecherche + " existe dans la liste ");
				else
					System.out.println(" la recherche n'existe pas ");

				System.out.println();
				System.out.println();
				System.out.println();
				app.menuPrincipal();
				choixMenu = sc.nextInt();
				System.out.print("\033\143");
				break;

			case 2:
				app.menuLivre();

				try {
					choixLivre = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Veuillez entrer un choix valide !");
				}

				switch (choixLivre) {
				/////////////////////////////////////////// Ajout un livre//////////////////////////////////////////////////////
				case 1:

					Book tmpBook = new Book();

					System.out.print("Entrer le titre du livre : ");
					tmpBook.setTitle(sc.next());
					System.out.print("Entrer le nom de l'auteur : ");
					tmpBook.setAuthor(sc.next());

					System.out.print("Entrer la langue du livre : ");
					tmpBook.setLanguage(sc.next());

					System.out.print("Entrer le nombre de page du livre : ");
					try {
						tmpBook.setTotalPage(sc.nextInt());
					} catch (Exception e) {
						System.out.println("Veuillez entrer une valeur valide !");
					}

					System.out.print("Entrer la durée d'un emprunt de ce livre : ");
					try {
						tmpBook.setLoanPeriod(sc.nextInt());
					} catch (Exception e) {
						System.out.print("Veuillez entrer une valeur valide !");

					}

					System.out.print("Entrer le prix de l'emprunt de ce livre : ");

					try {
						tmpBook.setRentalPrice(sc.nextDouble());
					} catch (Exception e) {
						System.out.println("Veuillez entrer une valeur valide !");
					}

					myLibrary.addBook(tmpBook);
					System.out.println(myLibrary.printBooks());

					break;
				case 2: //
					OnlineBook tmpOnlineBook = new OnlineBook();

					System.out.print("Entrer le titre du livre : ");
					tmpOnlineBook.setTitle(sc.next());

					System.out.print("Entrer le nom de l'auteur : ");
					tmpOnlineBook.setAuthor(sc.next());

					System.out.print("Entrer la langue du livre : ");
					tmpOnlineBook.setLanguage(sc.next());

					System.out.print("Entrer le nombre de page du livre : ");
					try {
						tmpOnlineBook.setTotalPage(sc.nextInt());
					} catch (Exception e) {
						System.out.println("Veuillez entrer une valeur valide !");
					}

					System.out.print("Entrer la durée d'un emprunt de ce livre : ");
					try {
						tmpOnlineBook.setLoanPeriod(sc.nextInt());
					} catch (Exception e) {
						System.out.print("Veuillez entrer une valeur valide !");

					}

					System.out.print("Entrer le prix de l'emprunt de ce livre : ");

					try {
						tmpOnlineBook.setRentalPrice(sc.nextDouble());
					} catch (Exception e) {
						System.out.println("Veuillez entrer une valeur valide !");
					}

					System.out.print("Entrer le nombre de personnes qui peuvent enprunter : ");
					try {
						tmpOnlineBook.setMaxPeople(sc.nextInt());
					} catch (Exception e) {
						System.out.print("Veuillez entrer une valeur valide !");

					}
					System.out.print("Description du livre : ");
					tmpOnlineBook.setContenu(sc.nextLine());

					myLibrary.addBook(tmpOnlineBook);
					System.out.println(myLibrary.printBooks());
					break;

				case 3:
					GraphicNovel tmpGraphicNovel = new GraphicNovel();

					System.out.print("Entrer le titre du livre : ");
					tmpGraphicNovel.setTitle(sc.next());

					System.out.print("Entrer le nom de l'auteur : ");
					tmpGraphicNovel.setAuthor(sc.next());

					System.out.print("Entrer la langue du livre : ");
					tmpGraphicNovel.setLanguage(sc.next());

					System.out.print("Entrer le nombre de page du livre : ");
					try {
						tmpGraphicNovel.setTotalPage(sc.nextInt());
					} catch (Exception e) {
						System.out.println("Veuillez entrer une valeur valide !");
					}

					System.out.print("Entrer la durée d'un emprunt de ce livre : ");
					try {
						tmpGraphicNovel.setLoanPeriod(sc.nextInt());
					} catch (Exception e) {
						System.out.print("Veuillez entrer une valeur valide !");

					}

					System.out.print("Entrer le prix de l'emprunt de ce livre : ");

					try {
						tmpGraphicNovel.setRentalPrice(sc.nextDouble());
					} catch (Exception e) {
						System.out.println("Veuillez entrer une valeur valide !");
					}

					System.out.print("Entrer le nom du dessinateur : ");
					try {
						tmpGraphicNovel.setCartoonist(sc.next());
					} catch (Exception e) {
						System.out.print("Veuillez entrer une valeur valide !");

					}
					System.out.print("Description du livre : ");
					tmpGraphicNovel.setColor(sc.nextLine());

					myLibrary.addBook(tmpGraphicNovel);
					System.out.println(myLibrary.printBooks());

					break;

				}
				// Ajout des methode finBooks dans la class MyLibrary et edité la class App pour
				// tester toutes les methodes "
				System.out.println(" Teste de recherche du livre dans la bibliotheque : ");
				System.out.print(" Entrer le nom  du livre a rechercher : ");
				String bookRecherche = sc.next();
				System.out.print(" Entrer le nom de l'auteur du livre a rechercher : ");
				String authorRecherche = sc.next();
				if (!myLibrary.findBooks(bookRecherche, authorRecherche).isEmpty())
					System.out.println(" Le livre " + bookRecherche + " existe dans la liste ");
				else
					System.out.println(" la recherche n'existe pas ");
				System.out.println();
				app.loadLibrary(myLibrary);
				System.out.println();
				System.out.println();
				System.out.println();
				app.menuPrincipal();
				choixMenu = sc.nextInt();
				System.out.print("\033\143");
				break;
			// Emprunter un livre case 3 
			case 3:
				System.out.println("===== NOUVEL EMPRUNT =====");

				System.out.print(" Entrer le nom du  livre à emprunter : ");
				bookRecherche = sc.next();
				// Crée une liste tmpBook et on l'a initialisé avec la methode finBooks de la
				// class MyLirary
				ArrayList<Book> tmpBook = myLibrary.findBooksByTitle(bookRecherche);
				if (!tmpBook.isEmpty()) {
							
					if (!tmpBook.isEmpty()) {

						Book book = tmpBook.get(0);
						System.out.print(" Entrer le nom de l'emprunteur");
						Person borrower = myLibrary.findPeople(sc.next());
						if (borrower.getName() != null) {
							book.setBorrower(borrower);
							LocalDate localDate = LocalDate.now();
							book.setBorrowingDate(localDate);
							System.out.println(
									" Votre emprunt est accordé, vous avez 5 jours pour retouner le livre . \n Bonne l'ècture !");
						} else
							System.out.println(" Vous n'etes pas un membre de notre bibliotheque .");
					}
				} else
					System.out.println(" Ce livre n'existe pas de notre bibliotheque ");
				System.out.println();
				System.out.println();
				System.out.println();
				app.menuPrincipal();
				choixMenu = sc.nextInt();
				System.out.print("\033\143");
				break;
			// ***************************** STATISTIQUES ************************
			/*
			 * case 4: System.out.println("===== STATISTIQUES =====");
			 * 
			 * int nbrBooks = 0, nbrGraphicNovels =0, nbrOnlineBooks = 0, nbrMembers = 0,
			 * nbrBorrowingMembers = 0, nbrBorrowedBooks = 0, nbrLateBooks = 0;
			 * 
			 * nbrBooks = myLibrary.getBooks().size(); nbrMembers =
			 * myLibrary.getPeople().size();
			 * 
			 * for (Book b : myLibrary.getBooks()) { if (b instanceof OnlineBook) {
			 * nbrOnlineBooks++; } else if (b instanceof GraphicNovel) { nbrGraphicNovels++;
			 * }
			 * 
			 * if (b.getBorrower() != null) nbrBorrowedBooks++;
			 * 
			 * if (b.computeRemainingdays() > 0) nbrLateBooks++; }
			 * 
			 * for (Person p : myLibrary.getPeople()) { if (p.getBooks().size() > 0)
			 * nbrBorrowingMembers++; } choixMenu = sc.nextInt();
			 * System.out.println("Nombre de livres : " + nbrBooks +
			 * " (Livres electroniques : " + nbrOnlineBooks + "/ Romans Graphiques : " +
			 * nbrGraphicNovels + ") / Nombre de membres : " + nbrMembers +
			 * "( Emprunteurs : " + nbrBorrowingMembers + ")");
			 * System.out.println("Nombre de livres empruntés " + nbrBorrowedBooks);
			 * System.out.println("Nombre de livres en retard : " + nbrLateBooks);
			 * 
			 * break;
			 */

			case 0:
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Veuillez entrer un nombre entre 0 et 4 !");
			}

		}
	}
}
