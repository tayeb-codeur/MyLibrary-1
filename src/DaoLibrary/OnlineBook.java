package DaoLibrary;

import java.time.LocalDate;

public class OnlineBook extends Book {
	private int maxPeople;
	private String contenu;

	public OnlineBook() {
		super();
	}

	public OnlineBook(int maxPeople, String contenu, String title, String author, int totalPage, Person borrower,
			int loanPeriod, double rentalPrice, LocalDate borrowingDate, String language) {

		super(title, author, totalPage, borrower, loanPeriod, rentalPrice, borrowingDate, language);
		this.maxPeople = maxPeople;
		this.contenu = contenu;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
