package intellij.model;

import intellij.model.ISearch;
import intellij.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class SearchLocation implements ISearch {

    double latitude;
    double longitude;
    double radius;

    public SearchLocation(double latitude, double longitude, double radius){
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public List<Restaurant> search(List<Restaurant> restaurants){
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : restaurants) {
            if (r.location.haversine(this.latitude, this.longitude) < radius) {
                result.add(r);
            }
        }
        int i = 1;
        if(result.size() > 0) {
            for (Restaurant r : result) {
                System.out.println(i + ". " + r);
                r.printReviews();
                i++;
            }
        } else {
            System.out.println("No restaurants found");
        }
        return result;
    }

}
