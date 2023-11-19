package com.RestaurantApp.Savor.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class LocationTest {
    public LocationTest() {}

    /*
     * Tests the haversine function, which finds the distance between two pairs of coordinates.
     */
    @Test
    public void testHaversine() {
        Location l = new Location("123 Test St.", 0, 0);
        assertTrue(l.haversine(0,0) == 0);
        assertTrue(l.haversine(5.0,5.0) > 0);
        assertTrue(l.haversine(-5.0,-5.0) > 0);
    }
}
