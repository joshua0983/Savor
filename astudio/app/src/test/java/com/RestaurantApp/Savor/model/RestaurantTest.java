package com.RestaurantApp.Savor.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantTest {
    public RestaurantTest() {}

    /*
     * Tests adding a review to a specific restaurant.
     */
    @Test
    public void addReviewTest() {
        Restaurant r = new Restaurant("Testaurant", 5.0, "123 Test St.", 100.0, 100.0, 0);
        Review rev = new Review("LOVED it!!", 5.0);;
        Review rev2 = new Review("HATED it!!", 1.0);;
        r.addReview(rev);
        r.addReview(rev2);
        assertEquals(rev, r.reviews.get(0));
    }

    /*
     * Tests the String form of a restaurant.
     */
    @Test
    public void testToString() {
        Restaurant r = new Restaurant("Testaurant", 5.0, "123 Test St.", 100.0, 100.0, 0);
        assertEquals("Testaurant, 123 Test St., 5.0 stars", r.toString());
    }
}