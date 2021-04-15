package ui;

import Metier.*;
import DaoLibrary.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MyLibrary myLibrary = new MyLibrary("BiblioICC");
        System.out.println("Chargement de la biblioth�que...");
        System.out.println(myLibrary.loadBooks("data/books.csv", myLibrary.getBooks()) + " livres charg�s...");
        System.out.println(myLibrary.loadMembers("data/members.csv", myLibrary.getPeople()) + " membres charg�s...");
        int choixMenu = 5;

        while (choixMenu != 0) {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Ajouter un membre");
            System.out.println("2. Ajouter un livre");
            System.out.println("3. Emprunter un livre");
            System.out.println("4. Voir les statistiques");
            System.out.println("0. Quitter le programme");

            try {
            	choixMenu = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            	System.out.println("Veuillez entrer une valeur valide !");
            }
          
        
            switch (choixMenu) {
                case 1:
                    System.out.println("===== NOUVEAU MEMBRE =====");
                    Person tmpPerson = new Person();
                    System.out.println("Quel est le nom du membre ?");
                    tmpPerson.setName(sc.nextLine());
                    System.out.println("Combien de livres le membre peut-il emprunter ?");

                    try {
                        tmpPerson.setMaxBooks(Byte.parseByte(sc.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("La valeur entr�e est invalide !");
                    }

                    myLibrary.addPerson(tmpPerson);
                    System.out.println("Le membre " + tmpPerson.getName() + " pouvant emprunter " + tmpPerson.getMaxBooks() + " livres a �t� cr�� !");

                    break;
                case 2:
                    System.out.println("===== NOUVEAU LIVRE =====");
                    System.out.println("1. Livre standard");
                    System.out.println("2. Livre Num�rique");
                    System.out.println("3. Roman Graphique");

                    int choixNvxLivre = 5;
                    try {
                        Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez entrer un choix valide !");
                    }

                    switch (choixNvxLivre) {
                        case 1:
                            Book tmpBook = new Book();

                            System.out.println("Quel est le titre du livre ?");
                            tmpBook.setTitle(sc.nextLine());

                            System.out.println("Qui est l'auteur du livre ?");
                            tmpBook.setAuthor(sc.nextLine());

                            System.out.println("Quelle est la langue du livre ?");
                            tmpBook.setLanguage(sc.nextLine());

                            System.out.println("Quel est le nombre de pages du livre ?");
                            try {
                                tmpBook.setTotalPage(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            System.out.println("Quel est la dur�e d'un emprunt de ce livre ?");
                            try {
                                tmpBook.setLoanPeriod(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            System.out.println("Quel est le prix d'un emprunt de ce livre ?");
                            try {
                                tmpBook.setRentalPrice(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            myLibrary.addBook(tmpBook);
                            System.out.println("Le livre " + tmpBook.getTitle() + " a �t� ajout� � la liste des livres !");

                            break;
                        case 2:
                            OnlineBook tmpOnlineBook = new OnlineBook();

                            System.out.println("Quel est le titre du livre ?");
                            tmpOnlineBook.setTitle(sc.nextLine());

                            System.out.println("Qui est l'auteur du livre ?");
                            tmpOnlineBook.setAuthor(sc.nextLine());

                            System.out.println("Quelle est la langue du livre ?");
                            tmpOnlineBook.setLanguage(sc.nextLine());

                            System.out.println("Quel est le contenu du livre ?");
                            tmpOnlineBook.setContent(sc.nextLine());

                            System.out.println("Quel est le nombre de pages du livre ?");
                            try {
                                tmpOnlineBook.setTotalPage(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            System.out.println("Quel est la dur�e d'un emprunt de ce livre ?");
                            try {
                                tmpOnlineBook.setLoanPeriod(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            System.out.println("Quel est le prix d'un emprunt de ce livre ?");
                            try {
                                tmpOnlineBook.setRentalPrice(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            System.out.println("Combien de personnes peuvent emprunter ce livre ?");
                            try {
                                tmpOnlineBook.setMaxPeople(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            myLibrary.addBook(tmpOnlineBook);
                            System.out.println("Le livre " + tmpOnlineBook.getTitle() + " a �t� ajout� � la liste des livres !");

                            break;
                        case 3:
                            GraphicNovel tmpGraphicNovel = new GraphicNovel();

                            System.out.println("Quel est le titre du livre ?");
                            tmpGraphicNovel.setTitle(sc.nextLine());

                            System.out.println("Qui est l'auteur du livre ?");
                            tmpGraphicNovel.setAuthor(sc.nextLine());

                            System.out.println("Qui est le dessinateur du livre ?");
                            tmpGraphicNovel.setCartoonist(sc.nextLine());

                            System.out.println("Quelle est la langue du livre ?");
                            tmpGraphicNovel.setLanguage(sc.nextLine());

                            System.out.println("Le livre est-il en couleurs ? (yes/no)");
                            tmpGraphicNovel.setColor(Boolean.parseBoolean(sc.nextLine()));

                            System.out.println("Quel est le nombre de pages du livre ?");
                            try {
                                tmpGraphicNovel.setTotalPage(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            System.out.println("Quel est la dur�e d'un emprunt de ce livre ?");
                            try {
                                tmpGraphicNovel.setLoanPeriod(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            System.out.println("Quel est le prix d'un emprunt de ce livre ?");
                            try {
                                tmpGraphicNovel.setRentalPrice(Integer.parseInt(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Veuillez entrer une valeur valide !");
                            }

                            myLibrary.addBook(tmpGraphicNovel);
                            System.out.println("Le livre " + tmpGraphicNovel.getTitle() + " a �t� ajout� � la liste des livres !");

                            break;
                        default:
                    }

                    break;
                case 3:
                    System.out.println("===== NOUVEL EMPRUNT =====");

                    String inputBook, inputMember;
                    int idBook = 0, idMember = 0;

                    System.out.println("Quel est le livre � emprunter (0 pour annuler) ?");
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

                    System.out.println("Donnez l'ID du livre � emprunter (0 pour annuler)");

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

                    System.out.println("Le livre " + myLibrary.getBooks().get(idBook).getTitle() + " doit �tre retourn� pour le " + myLibrary.getBooks().get(idBook).getBorrowingDate().plusDays(myLibrary.getBooks().get(idBook).getLoanPeriod()).toString());
                    System.out.println("SYNTHESE : " + myLibrary.getPeople().get(idMember).getName() + " emprunte le livre " + myLibrary.getBooks().get(idBook).getTitle() + " et doit le retourner pour le " + myLibrary.getBooks().get(idBook).getBorrowingDate().plusDays(myLibrary.getBooks().get(idBook).getLoanPeriod()).toString());

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

                        if (b.computeRemainingdays() > 0) nbrLateBooks++;
                    }

                    for (Person p : myLibrary.getPeople()) {
                        if (p.getBooks().size() > 0) nbrBorrowingMembers++;
                    }

                    System.out.println("Nombre de livres : " + nbrBooks + " (Livres electroniques : " + nbrOnlineBooks + "/ Romans Graphiques : " + nbrGraphicNovels + ") / Nombre de membres : " + nbrMembers + "( Emprunteurs : " + nbrBorrowingMembers + ")");
                    System.out.println("Nombre de livres emprunt�s " + nbrBorrowedBooks);
                    System.out.println("Nombre de livres en retard : " + nbrLateBooks);

                    break;
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
