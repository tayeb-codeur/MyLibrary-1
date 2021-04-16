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
    
	public MyLibrary() {}
	
	public MyLibrary(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
		this.people = new ArrayList<Person>();
	}
	
	public MyLibrary(String name,ArrayList<Book> books,ArrayList<Person> people ) {
		this.name = name;
		this.books = books;
		this.people = people;
	}

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
	
	public void editeBook(Book book,int totalPage, Person borrower, int loanPeriod, double rentalPrice,
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
	

	public boolean addPerson(Person person) {
		return this.people.add(person);
	}
	
	public boolean removePerson(Person person) {
		return this.people.remove(person);
	}
	
	public void editePerson(Person person,String name, int maxBooks) {
		person.setName(name);
		person.setMaxBooks(maxBooks);
		
	}
	
	public void displayPersons() {
		System.out.println(people);
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

				System.out.println(++cpt + ": " + p.getName());
			}
			return cpt;
		}

	}
