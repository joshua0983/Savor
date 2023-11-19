package com.RestaurantApp.Savor.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public String name;
    double rating;
    List<Review> reviews = new ArrayList<>();
    Location location;

    final double initialRating;
    public int id;



    public Restaurant(String name, double rating, String address, double lat, double lon, int id){
        this.name = name;
        this.rating = rating;
        this.location = new Location(address, lat, lon);
        initialRating = rating;
        this.id = id;
    }

    /*
     * Adds the inputted review to the restaurant's list of reviews.
     */
    public void addReview (Review r) {
        reviews.add(r);
        double ratings = initialRating;
        for(int i=0; i<this.reviews.size(); i++){
            ratings += this.reviews.get(i).rating;
        }
        double average = ratings/(this.reviews.size()+1);
        this.rating = average;
    }
    public String toString () {
        return name + ", " + location.address + ", " + rating + " stars";
    }
    public String getName() {
        return name;
    }
    public String getRating() {
        return String.format("%.1f", rating);
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
