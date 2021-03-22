package com.icc.main;

import java.util.Date;

public class GraphicNovel extends Book{
    private String cartoonist;
    private boolean color;

    GraphicNovel(String title, String author, Person person, int totalPages, int loanPeriod, int rentalPrice, Date borrowingDate, String language, String cartoonist, boolean color){
        super(title, author, person, totalPages, loanPeriod, rentalPrice, borrowingDate, language);
        this.cartoonist = cartoonist;
        this.color = color;
    }

    GraphicNovel() {
        super();
        this.cartoonist = "Cartoonist";
        this.color = false;
    }

    public void setCartoonist(String cartoonist) {
        this.cartoonist = cartoonist;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}
