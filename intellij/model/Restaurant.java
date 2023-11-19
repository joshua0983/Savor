package intellij.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public String name;
    double rating;
    List<Review> reviews = new ArrayList<>();
    Location location;

    final double initialRating;



    public Restaurant(String name, double rating, String address, double lat, double lon){
        this.name = name;
        this.rating = rating;
        this.location = new Location(address, lat, lon);
        initialRating = rating;
    }

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

    public void printReviews() {
        if(reviews.size() == 0) {
            System.out.println("No reviews posted.");
        }
        for (Review r: this.reviews) {
            System.out.println(r.rating + ": " + r.text);
        }
    }
}
