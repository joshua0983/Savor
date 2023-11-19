package com.RestaurantApp.Savor.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReviewTest {
    public ReviewTest() {}

    /*
     * Tests the String form of a review.
     */
    @Test
    public void testToString() {
        Review r = new Review("Test review", 5.0);
        assertEquals("5.0 stars\nTest review", r.toString());
    }
}