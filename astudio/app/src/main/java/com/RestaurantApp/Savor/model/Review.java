package com.RestaurantApp.Savor.model;

public class Review {
    String text;
    double rating;

    public Review(String text, double rating) {
        this.text = text;
        this.rating = rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String toString() {

        return rating + " stars\n" + text;
    }

    public String getText() { return text;
    }

}
