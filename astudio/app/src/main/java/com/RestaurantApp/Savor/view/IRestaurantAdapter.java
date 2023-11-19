package com.RestaurantApp.Savor.view;

import androidx.annotation.NonNull;

import com.RestaurantApp.Savor.model.Restaurant;

public interface IRestaurantAdapter {

    interface Listener{
        void onItemClick(Restaurant restaurant);

    }

}

