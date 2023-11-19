package com.RestaurantApp.Savor.model;

import org.junit.Test;
import static org.junit.Assert.*;
public class LibraryTest {
    public LibraryTest() {}

    /*
     * Tests adding a review to a restaurant in the library.
     */
    public void testAddReviewToLibrary() {
        Review rev = new Review("Test review", 5.0);
        RestaurantLibrary lib = new RestaurantLibrary();
        lib.addReviewToLibrary(rev,0);
        assertEquals("Test review", lib.library.get(0).getReviews().get(0).getText());
    }
}
