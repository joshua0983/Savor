package com.RestaurantApp.Savor.model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchLocationTest {
    public SearchLocationTest() {}

    /*
     * Tests searching a list of restaurants by maximum distance.
     */
    @Test
    public void testSearch() {
        List<Restaurant> listy = new ArrayList<>(Arrays.asList(
                new Restaurant("Testaurant", 3.0, "123 Test St.", 41.69024, -73.89556, 0)));
        SearchLocation searcher = new SearchLocation(10);
        assertEquals("Testaurant", searcher.search(listy).get(0).name);
    }
}
