package com.RestaurantApp.Savor.view;

import com.RestaurantApp.Savor.model.Restaurant;

import java.util.List;

public interface ISearchView {

    void displayResults(List<Restaurant> searchResults);

    interface Listener {


        void searchByName(String searchParam, ISearchView searchView);


        void searchByLocation(double searchParam, ISearchView searchView);

        void searchByRating(double searchParam, ISearchView searchView);

        void clickedRestaurant(Restaurant restaurant);

        void onBackPressed();

        //void displayResults(List<Restaurant> searchResults);
        


    }




}
