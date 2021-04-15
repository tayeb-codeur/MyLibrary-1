package Metier;

import DaoLibrary.Book;

public class OnlineBook extends Book {
	
	private int maxPeople;
	private String content;
	
	 OnlineBook(String title, String author, int totalPages, int loanPeriod, int rentalPrice, String language, int maxPeople, String content){
	        super(title, author, totalPages, loanPeriod, rentalPrice, language);
	        this.maxPeople = maxPeople;
	        this.content = content;
	    }
	 
	 public OnlineBook() {
	        super();
	        this.maxPeople = 0;
	        this.content = "Unknown";
	    }
	 
		public int getMaxPeople() {
			return maxPeople;
		}

		public String getContent() {
			return content;
		}

		public void setMaxPeople(int maxPeople) {
			this.maxPeople = maxPeople;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	}
