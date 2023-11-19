package com.RestaurantApp.Savor.view;
import com.RestaurantApp.Savor.model.Review;
import com.RestaurantApp.Savor.model.Restaurant;

import java.util.List;


public interface IReviewView {

    void displayReviews(List<Review> reviews);

    interface Listener {
        void onReviewPosted(Restaurant r, double rating, String reviewText);

        void onBackPressed();

        void displaySearchFragment();
    }

    void updateDisplayOnPost();
}
