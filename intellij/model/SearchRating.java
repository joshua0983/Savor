package intellij.model;

import java.util.ArrayList;
import java.util.List;

public class SearchRating implements ISearch {
    double rating;

    public SearchRating(double rating){
        this.rating = rating;
    }
    public List<Restaurant> search(List<Restaurant> restaurants){
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : restaurants) {
            if (r.rating >= this.rating) {
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

