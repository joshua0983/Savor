package com.RestaurantApp.Savor.model;

import java.util.ArrayList;
import java.util.List;

public class SearchLocation implements ISearch {

    final double latitude = 41.68686;
    final double longitude = -73.89524;
    double radius;

    public SearchLocation(double loc){
        this.radius = loc;
    }

    /*
     * Searches a list of restaurants and returns a list of restaurants whose latitude and longitude
     * position are within the double radius (in km).
     */
    public List<Restaurant> search(List<Restaurant> restaurants){
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : restaurants) {
            if (r.location.haversine(this.latitude, this.longitude) < radius) {
                result.add(r);
            }
        }
        return result;
    }

}
