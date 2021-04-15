package Metier;

import java.time.LocalDate;

import DaoLibrary.Book;

public class GraphicNovel extends Book {
	
	private String cartoonist;
	private boolean color;
	private LocalDate date;
		
	GraphicNovel(String title, String author, int totalPages, int loanPeriod, int rentalPrice, String language, String cartoonist, boolean color){
        
		super(title, author, totalPages, loanPeriod, rentalPrice, language);
        this.cartoonist = cartoonist;
        this.color = color;
    }
	
	
	public GraphicNovel() {
        super();
        this.cartoonist = "Cartoonist";
        this.color = false;
    }
	
	public void setCartoonist(String cartoonist) {
        this.cartoonist = cartoonist;
    }
	
	
	public String getCartoonist() {
        return cartoonist;
    }
	
	public void setColor(boolean color) {
        this.color = color;
    }
	
	public Boolean getColor() {
        return color;
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
