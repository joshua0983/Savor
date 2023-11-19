package com.RestaurantApp.Savor.model;

import java.util.ArrayList;
import java.util.List;

public class SearchName implements ISearch {

    String name;
    public SearchName(String name){
        this.name = name;
    }

    /*
     * Searches a list of restaurants and returns a list of restaurants whose name contains the
     * String name, ignoring case.
     */
    public List<Restaurant> search(List<Restaurant> restaurants){
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.name.toLowerCase().contains(this.name.toLowerCase())) {
                result.add(restaurant);
            }
        }

        int i = 1;

        return result;
}
}