package com.icc.main;

import java.util.Date;

public class GraphicNovel extends Book{
    private String cartoonist;
    private String color;

    GraphicNovel(String title, String author, int totelPages, int loanPeriod, int rentalPrice, Date borrowingDate, String language, String cartoonist, String color){
        super(title, author, totelPages, loanPeriod, rentalPrice, borrowingDate, language);
        this.cartoonist = cartoonist;
        this.color = color;
    }

    GraphicNovel() {
        super();
        this.cartoonist = "Cartoonist";
        this.color = "Black";
    }
}
