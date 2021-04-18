package Metier;

import DaoLibrary.Book;
import DaoLibrary.DaoLibrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import DaoLibrary.Person;

public class MyLibrary implements DaoLibrary {

	private String name;
	private ArrayList<Book> books;
	private ArrayList<Person> people;

	public MyLibrary() {
	}

	public MyLibrary(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
		this.people = new ArrayList<Person>();
	}

	public MyLibrary(String name, ArrayList<Book> books, ArrayList<Person> people) {
		this.name = name;
		this.books = books;
		this.people = people;
	}
	// les methodes

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	@Override
	public String toString() {
		final int maxLen = 3;
		return "MyLibrary [name=" + name + ", books="
				+ (books != null ? books.subList(0, Math.min(books.size(), maxLen)) : null) + ", people="
				+ (people != null ? people.subList(0, Math.min(people.size(), maxLen)) : null);
	}

	public boolean addBook(Book book) {
		return this.books.add(book);
	}

	public boolean removeBook(Book book) {
		return this.books.remove(book);
	}

	public void editeBook(Book book, int totalPage, Person borrower, int loanPeriod, double rentalPrice,
			LocalDate borrowingDate, String language) {

		book.setTotalPage(totalPage);
		book.setLoanPeriod(loanPeriod);
		book.setRentalPrice(rentalPrice);
		book.setBorrower(borrower);
		book.setLanguage(language);
		book.setBorrowingDate(borrowingDate);
	}

	public void displayBooks() {
		System.out.println(books);
	}

	// Rechercher les livres selon titre et l'auteur
	public ArrayList<Book> findBooks(String title, String author) {
		ArrayList<Book> tmpBooks = new ArrayList<>();
		for (int i = 0; i < books.size(); ++i) {
			if (books.get(i).getTitle().equals(title) && books.get(i).getAuthor().equals(author))
				tmpBooks.add(books.get(i));
		}
		return tmpBooks;
	}

	public boolean addPerson(Person person) {
		return this.people.add(person);
	}

	public boolean removePerson(Person person) {
		return this.people.remove(person);
	}

	public void editePerson(Person person, String name, int maxBooks) {
		person.setName(name);
		person.setMaxBooks(maxBooks);
	}

	public void displayPersons() {
		System.out.println(people);
	}

	// Rechercher des membres selon nom
	public ArrayList<Person> findPeople(String name) {
		ArrayList<Person> tmpPersons = new ArrayList<Person>();
		for (int i = 0; i < people.size(); ++i) {
			if (people.get(i).getName().equals(name))

				tmpPersons.add(people.get(i));
		}
		return tmpPersons;
	}

	public int printBooks() {
		int cpt = 0;

		Iterator<Book> it = this.getBooks().iterator();

		while (it.hasNext()) {
			Book b = it.next();
			System.out.println(++cpt + ": " + b.getTitle() + " - " + b.getAuthor());
		}
		return cpt;
	}

	public int printMembers() {
		int cpt = 0;

		Iterator<Person> itp = this.getPeople().iterator();

		while (itp.hasNext()) {
			Person p = itp.next();

			System.out.println(++cpt + " : " + p.getName());
		}
		return cpt;
	}

}
