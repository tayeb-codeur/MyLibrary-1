package DaoLibrary;


import java.time.LocalDate;


public class Book {
	
	private String title;
	private String author;
	private int totalPage;
	private int loanPeriod;
	private double rentalPrice;
	private Person borrower;
	private String language;
	private LocalDate borrowingDate ;	
	
	// constructeur sans parametre
	public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.borrower = null;
        this.totalPage = 0;
        this.loanPeriod = 0;
        this.rentalPrice = 0;
        this.language = "Unknown language";
    }
	 // constructeur surcharge avec parametre
	public Book(String title, String author, int totalPage, int loanPeriod, double rentalPrice, String language) {
		this.title = title;
		this.author = author;
		this.totalPage = totalPage;
		this.loanPeriod = loanPeriod;
		this.rentalPrice = rentalPrice;
		this.language = language;
	}
	// constructeur surcharge  avec parametre  
	public Book(String title, String author, int totalPage, Person borrower, int loanPeriod, double rentalPrice,
			LocalDate borrowingDate, String language) {
		this.title = title;
		this.author = author;
		this.totalPage = totalPage;
		this.borrower = borrower;
		this.loanPeriod = loanPeriod;
		this.rentalPrice = rentalPrice;
		this.borrowingDate = borrowingDate;
		this.language = language;

	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getLoanPeriod() {
		return loanPeriod;
	}


	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}


	public double getRentalPrice() {
		return rentalPrice;
	}


	public void setRentalPrice(int rentalPrice) {
		this.rentalPrice = rentalPrice;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}
	
		
	public Person getBorrower() {
		return borrower;
	}

	public void setBorrower(Person borrower) {
		this.borrower = borrower;
	}

	public LocalDate getBorrowingDate() {
		return borrowingDate;
	}

	public void setBorrowingDate(LocalDate borrowingDate) {
		this.borrowingDate = borrowingDate;
	}
	
	public Integer computeRemainingdays() {
		return borrowingDate.plusDays((long)this.loanPeriod).compareTo(LocalDate.now());
	}

	@Override
	public  String toString() {
		return "Books [title=" + title + ", author=" + author + ", totalPage=" + totalPage + ", loanPeriod="
				+ loanPeriod + ", rentalPrice=" + rentalPrice + ", language=" + language + ", getTitle()=" + getTitle()
				+ ", getAuthor()=" + getAuthor() + ", getTotalPage()=" + getTotalPage() + ", getLoanPeriod()="
				+ getLoanPeriod() + ", getRentalPrice()=" + getRentalPrice() + ", getLanguage()=" + getLanguage() + "]";
	}
	 
	/*public static void  main (String []args) {
		Book book = new Book();
		System.out.println(book.toString());
	}*/
}
