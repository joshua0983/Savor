package com.RestaurantApp.Savor.view;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.RestaurantApp.Savor.R;
import com.RestaurantApp.Savor.databinding.FragmentReviewBinding;

import com.RestaurantApp.Savor.model.Restaurant;
import com.RestaurantApp.Savor.model.RestaurantLibrary;
import com.RestaurantApp.Savor.model.Review;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewFragment extends Fragment implements IReviewView{
    private FragmentReviewBinding binding;
    Listener listener;
    String text = "";
    double rating = 0.0;
    Restaurant currentRestaurant;


    public ReviewFragment(Restaurant r, @NonNull IReviewView.Listener listener){
        this.currentRestaurant = r;
        this.listener = listener;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentReviewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

//    @Override
//    public void onBackPressed() {
//        // Get the current fragment
//        Fragment currentFragment = getParentFragment();
//
//        // Check if the current fragment is not the main fragment
//        if (currentFragment != null && currentFragment.getTag() != null && !currentFragment.getTag().equals("main")) {
//            // Navigate back to the previous fragment
//            getSupportFragmentManager().popBackStack();
//        } else {
//            // If the current fragment is the main fragment, handle as usual
//            super.onBackPressed();
//        }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // The callback can be enabled or disabled here or in handleOned()

        TextView restaurant_display = getView().findViewById(R.id.restaurant_display);
        TextView restaurant_rating = getView().findViewById(R.id.restaurant_rating);
        restaurant_display.setText(currentRestaurant.getName());
        restaurant_rating.setText("Rating: " + currentRestaurant.getRating());
        ReviewFragment.this.displayReviews(currentRestaurant.getReviews());
        this.binding.postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ReviewLogs", "Post button clicked");
                rating = ReviewFragment.this.binding.ratingBar.getRating();
                text = ReviewFragment.this.binding.reviewText.getText().toString();
                ReviewFragment.this.listener.onReviewPosted(currentRestaurant, rating, text);
                listener.displaySearchFragment();
            }
        });
    }


    public void updateDisplayOnPost() {

    }

    @Override
    public void displayReviews(List<Review> reviews) {
//        Log.d("SearchFragmentLogs", "Displaying search results: " + searchResults.size());
        //      restaurantList.clear();
        //    restaurantList.addAll(searchResults);
        //  adapter.notifyDataSetChanged();
        //Log.d("SearchLogs", "Number of restaurants: " + restaurantList.size());
//
        this.binding.reviewsList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        this.binding.reviewsList.setAdapter(new ReviewAdapter(this.getContext(), reviews, listener));
    }
}


