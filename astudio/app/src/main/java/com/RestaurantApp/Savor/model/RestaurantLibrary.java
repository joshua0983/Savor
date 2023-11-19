package com.RestaurantApp.Savor.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantLibrary {
    public static List<Restaurant> library = new ArrayList<>(Arrays.asList(
            new Restaurant("Gordon Commons (The Deece)", 3.9, "124 Raymond Ave", 41.69024, -73.89556, 0),
            new Restaurant("Pizzeria Bacio", 4.4, "7 Collegeview Ave", 41.69613, -73.89967, 1),
            new Restaurant("Thai Spice", 4.1, "28 Raymond Ave", 41.69142, -73.90094, 2),
            new Restaurant("Wendy's", 3.8, "753 Main St", 41.69708, -73.90430, 3),
            new Restaurant("McDonald's", 3.6, "733 Main St", 41.69738, -73.90622, 4),
            new Restaurant("Shadows on the Hudson", 4.5, "176 Rinaldi Blvd", 41.69845, -73.93989, 5)
    ));

    public RestaurantLibrary(){
    }

    public void addRestaurant(Restaurant r) {
        library.add(r);
    }

    public List<Restaurant> display(){
        return library;
    }

    public Restaurant getRestaurant(int id) {
        return library.get(id);
    }

    /*
     * Adds the input review to the restaurant whose id matches the input int.
     */
    public void addReviewToLibrary(Review r, int id) {
        Restaurant currentRestaurant = library.get(id);
        currentRestaurant.addReview(r);
        library.set(id, currentRestaurant);
    }
}
