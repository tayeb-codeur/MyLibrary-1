package DaoLibrary;

import java.time.LocalDate;

public class GraphicNovel extends Book {
	private String cartoonist;
	private String color;

	public GraphicNovel() {
	}

	public GraphicNovel(String cartoonist, String color, String title, String author, int totalPage, Person borrower,
			int loanPeriod, double rentalPrice, LocalDate borrowingDate, String language) {

		super(title, author, totalPage, borrower, loanPeriod, rentalPrice, borrowingDate, language);
		this.cartoonist = cartoonist;
		this.color = color;
	}

	public String getCartoonist() {
		return cartoonist;
	}

	public void setCartoonist(String cartoonist) {
		this.cartoonist = cartoonist;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
