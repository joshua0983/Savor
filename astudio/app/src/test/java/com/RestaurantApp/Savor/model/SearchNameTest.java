package com.RestaurantApp.Savor.model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchNameTest {

    /*
     * Tests searching a list of restaurants by name.
     */
    public SearchNameTest() {}

    @Test
    public void testSearch() {
        List<Restaurant> listy = new ArrayList<>(Arrays.asList(
                new Restaurant("Testaurant", 3.0, "123 Test St.", 0.0, 0.0, 0)));
        SearchName searcher = new SearchName("test");
        assertEquals("Testaurant", searcher.search(listy).get(0).name);
    }
}
