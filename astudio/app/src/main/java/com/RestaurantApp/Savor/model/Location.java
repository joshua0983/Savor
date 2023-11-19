package com.RestaurantApp.Savor.model;

public class Location {
    String address;
    public double longitude;
    public double latitude;

    public Location(String address, double latitude, double longitude){
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /*
    Calculates the distance between a pair of coordinates and the local pair
    of coordinates.
     */
    public double haversine(double lat1, double lon1)
    {

        // distance between latitudes and longitudes
        double dLat = Math.toRadians(this.latitude - lat1);
        double dLon = Math.toRadians(this.longitude - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        double lat3 = Math.toRadians(this.latitude);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat3);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }
}
