package intellij.model;

import java.util.ArrayList;
import java.util.List;

public class SearchName implements ISearch {

    String name;
    public SearchName(String name){
        this.name = name;
    }
    public List<Restaurant> search(List<Restaurant> restaurants){
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.name.toLowerCase().contains(this.name.toLowerCase())) {
                result.add(restaurant);
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