package intellij.model;

import intellij.model.Restaurant;

import java.util.List;

public interface ISearch {
    public List<Restaurant> search(List<Restaurant> restaurants);
}
