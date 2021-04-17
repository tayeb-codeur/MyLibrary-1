package ui;

import Metier.*;
import DaoLibrary.*;
import DaoLibrary.GraphicNovel;
import DaoLibrary.OnlineBook;

import java.util.Scanner;
import java.util.UUID;

public class App {

	public void menuPrincipal() {
		System.out.println("\t\t\t\t\t\t***** MENU PRINCIPAL *****");
		System.out.println("1. Ajouter un membre - 2. Ajouter un livre - 3. Emprunter un livre - "
				+ " 4. Voir les statistiques - 0. Quitter le programme");
		System.out.println(
				"*****************************************************************************************************");
	}

	public void menuLivre() {
		System.out.println("===== NOUVEAU LIVRE =====");
		System.out.println("1. Livre standard");
		System.out.println("2. Livre Numérique");
		System.out.println("3. Roman Graphique");
		System.out.println(
				"************************************************************************************************************");
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		MyLibrary myLibrary = new MyLibrary("BiblioICC");
		System.out.println("Chargement de la bibliothèque...");
		System.out.println(myLibrary.loadBooks("data/books.csv", myLibrary.getBooks()) + " livres chargés...");
		System.out.println(myLibrary.loadMembers("data/members.csv", myLibrary.getPeople()) + " membres chargés...");

		// variables pour le choix entre par utilisateur
		int choixMenu = 0;
		String nouveauMembre = null;
		int nbMax = 0;
		int choixLivre = 0;

		App app = new App();
		app.menuPrincipal();

		// while (choixMenu != 0) {

		try {
			choixMenu = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Veuillez entrer une valeur valide !");
		}

		switch (choixMenu) {
		case 1:
			System.out.println("===== NOUVEAU MEMBRE =====");
			System.out.print("Entrer le nom du membre : ");
			nouveauMembre = sc.next();
			// UUID.randomUUID() generé un identifiant automatique
			Person tmpPerson = new Person(UUID.randomUUID(), nouveauMembre);
			System.out.println("--------------------------------------------------");
			System.out.print("Nombre de livres maximum que le membre peut emprunter : ");
			try {
				nbMax = sc.nextInt();
			} catch (Exception e) {
				System.out.println("La valeur entrée est invalide !");
			}
			tmpPerson.setMaxBooks(nbMax);
			myLibrary.addPerson(tmpPerson);
			// System.out.print("\033\143");
			/*
			 * System.out.println("le nom du nouveau membre : " + tmpPerson.getName() +
			 * " , le membre peut enprunté : " + tmpPerson.getMaxBooks() + " livres ");
			 * System.out.println();
			 */
			System.out.println(myLibrary.printMembers());
			System.out.println("*******************************************************************************");
			break;
		case 2:
			app.menuLivre();
			///////////////////////////////////////////////////////
			try {
				choixLivre = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Veuillez entrer un choix valide !");
			}

			switch (choixLivre) {
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
				// System.out.println("Le livre \' " + tmpBook.getTitle().toUpperCase() + " \' a
				// été ajouté à la liste des livres !");
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

					System.out.print("Entrer le nombre de personnes qui peuvent enprunter : ");
					try {
						tmpGraphicNovel.setCartoonist(sc.next());
					} catch (Exception e) {
						System.out.print("Veuillez entrer une valeur valide !");

					}
					System.out.print("Description du livre : ");
					tmpGraphicNovel.setColor(sc.next());

					myLibrary.addBook(tmpGraphicNovel);
					System.out.println(myLibrary.printBooks());
			  
			  break;
			 
			default:
			}

			break;
		/*
		 * case 3: System.out.println("===== NOUVEL EMPRUNT =====");
		 * 
		 * String inputBook, inputMember; int idBook = 0, idMember = 0;
		 * 
		 * System.out.println("Quel est le livre à emprunter (0 pour annuler) ?");
		 * inputBook = sc.nextLine();
		 * 
		 * if (inputBook == "0") break;
		 * 
		 * for (Book b : myLibrary.getBooks()) { if (b.getTitle().contains(inputBook)) {
		 * if (b.getBorrower() != null) {
		 * System.out.println(myLibrary.getBooks().indexOf(b) + ". " + b.getTitle() +
		 * " - DISPO"); } else { System.out.println(b.getTitle() + " - NON DISPO"); } }
		 * }
		 * 
		 * System.out.println("Donnez l'ID du livre à emprunter (0 pour annuler)");
		 * 
		 * try { idBook = Integer.parseInt(sc.nextLine()); } catch
		 * (NumberFormatException e) {
		 * System.out.println("Veuillez entrer une valeur correcte !"); }
		 * 
		 * if (idBook == 0) break;
		 * 
		 * System.out.println("Quel est le nom de l'emprunteur (0 pour annuler) ?");
		 * inputMember = sc.nextLine();
		 * 
		 * if (inputMember == "0") break;
		 * 
		 * for (Person p : myLibrary.getPeople()) { if
		 * (p.getName().contains(inputMember)) { if (p.getBooks().size() <
		 * p.getMaxBooks()) { System.out.println(myLibrary.getPeople().indexOf(p) + ". "
		 * + p.getName() + " - PEUT EMPRUNTER"); } else { System.out.println(p.getName()
		 * + " - NE PEUT PLUS EMPRUNTER"); } } }
		 * 
		 * System.out.println("Donnez l'ID du membre emprunteur (0 pour annuler)");
		 * 
		 * try { idMember = Integer.parseInt(sc.nextLine()); } catch
		 * (NumberFormatException e) {
		 * System.out.println("Veuillez entrer une valeur correcte !"); }
		 * 
		 * if (idMember == 0) break;
		 * 
		 * myLibrary.getBooks().get(idBook).setBorrower(myLibrary.getPeople().get(
		 * idMember));
		 * myLibrary.getPeople().get(idMember).getBooks().add(myLibrary.getBooks().get(
		 * idBook));
		 * 
		 * System.out.println("Le livre " + myLibrary.getBooks().get(idBook).getTitle()
		 * + " doit être retourné pour le " +
		 * myLibrary.getBooks().get(idBook).getBorrowingDate().plusDays(myLibrary.
		 * getBooks().get(idBook).getLoanPeriod()).toString());
		 * System.out.println("SYNTHESE : " +
		 * myLibrary.getPeople().get(idMember).getName() + " emprunte le livre " +
		 * myLibrary.getBooks().get(idBook).getTitle() +
		 * " et doit le retourner pour le " +
		 * myLibrary.getBooks().get(idBook).getBorrowingDate().plusDays(myLibrary.
		 * getBooks().get(idBook).getLoanPeriod()).toString());
		 * 
		 * break; case 4: System.out.println("===== STATISTIQUES =====");
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

		// }
	}
}
