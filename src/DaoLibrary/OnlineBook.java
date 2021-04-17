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

}
