package com.RestaurantApp.Savor.controller;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.RestaurantApp.Savor.R;

import java.util.List;

import com.RestaurantApp.Savor.model.Review;
import com.RestaurantApp.Savor.view.IRestaurantAdapter;
import com.RestaurantApp.Savor.view.ISearchView;
import com.RestaurantApp.Savor.view.IReviewView;
import com.RestaurantApp.Savor.model.Restaurant;
import com.RestaurantApp.Savor.model.RestaurantLibrary;
import com.RestaurantApp.Savor.model.SearchName;
import com.RestaurantApp.Savor.model.SearchLocation;
import com.RestaurantApp.Savor.model.SearchRating;
import com.RestaurantApp.Savor.view.MainView;
import com.RestaurantApp.Savor.view.ReviewFragment;
import com.RestaurantApp.Savor.view.SearchFragment;


public class MainActivity extends AppCompatActivity implements ISearchView.Listener, IRestaurantAdapter, IReviewView.Listener {

    MainView mainView;

    /*
     * Displays the main fragment and search fragment when app is run.
     * Also adds test reviews to each restaurant.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mainView = new MainView(this);
        SearchFragment searchFragment = new SearchFragment(this);
        this.mainView.displayFragment(searchFragment, false, "search");

        RestaurantLibrary l = new RestaurantLibrary();
        l.addReviewToLibrary(new Review("They don't even have Raisin Bran!!", 2.0),0);
        l.addReviewToLibrary(new Review("Absolutely divine! It is a true gem in the city. The ambiance is cozy, the service is impeccable, and the menu is a gastronomic delight. I highly recommend their signature dish, the truffle-infused risotto—it's a flavor explosion in every bite!", 5.0),0);
        l.addReviewToLibrary(new Review("Disappointing experience.The pizza crust was too thin and overcooked, making it taste like cardboard. The toppings were sparse, and the tomato sauce lacked flavor. Service was slow, and the overall atmosphere was dull. Definitely not worth a second visit.", 1.0),1);
        l.addReviewToLibrary(new Review("A hidden gem! The coffee is expertly brewed, and the pastries are heavenly. The staff is friendly, and the free Wi-Fi makes it a great place to work or catch up with friends. A must-visit for coffee lovers seeking a serene escape.", 4.5),2);
        l.addReviewToLibrary(new Review("This place boasts a menu with bold flavors, but execution falls short. The dishes lacked the depth of spices promised, and some were overly oily. The decor is uninspiring, and the service was average. With so many other options in the area, I wouldn't rush back.", 3.0),3);
        l.addReviewToLibrary(new Review("Charming and cozy, This place offers a delightful dining experience. The menu is a mix of comfort food and innovative dishes. The homemade desserts are a highlight—don't miss the chocolate lava cake! The service is warm and attentive, making it a perfect spot for a casual yet special night out.", 4.5),3);
        l.addReviewToLibrary(new Review("A haven for vegetarians and vegans! This place offers a diverse menu with creative and flavorful plant-based dishes. The atmosphere is bright and cheerful, and the staff is knowledgeable about the ingredients. The walnut and lentil burger is a standout—full of savory goodness. Even non-vegetarians will find the options here satisfying and delicious.", 5.0),5);
        l.addReviewToLibrary(new Review("This place boasts a robust selection of steaks, but the execution fell short of expectations. My food was overcooked and lacked the promised char, resulting in a dry and disappointing experience. The sides were mediocre, and the service was average. For the price, there are better restaurants in town that deliver a more satisfying dining experience.", 3.0),1);
    }

    /*
     * Displays the search fragment.
     */
    public void displaySearchFragment(){
        SearchFragment searchFragment = new SearchFragment(this);
        this.mainView.displayFragment(searchFragment, true, "search");
    }

    /*
     * Searches the restaurant library and returns a list of restaurants that contain the input string
     * in their name.
     */
    @Override
    public void searchByName(String searchParam, ISearchView searchView) {
        Log.d("MainActivityLogs", "Search by name method invoked");
        SearchName search = new SearchName(searchParam);
        List<Restaurant> results = search.search(RestaurantLibrary.library);
        searchView.displayResults(results);
    }

    /*
     * Searches the restaurant library and returns a list of restaurants that are within the radius
     * of the input double.
     */
    @Override
    public void searchByLocation(double searchParam, ISearchView searchView) {
        SearchLocation search = new SearchLocation(searchParam);
        List<Restaurant> results = search.search(RestaurantLibrary.library);
        searchView.displayResults(results);
    }

    /*
     * Searches the restaurant library and returns a list of restaurants whose ratings are above
     * the input double.
     */
    @Override
    public void searchByRating(double searchParam, ISearchView searchView) {
        SearchRating search = new SearchRating(searchParam);
        List<Restaurant> results = search.search(RestaurantLibrary.library);
        searchView.displayResults(results);
    }

    /*
     * Creates a new review with the input double and String, and adds it to the input restauraunt
     * within the library.
     */
    @Override
    public void onReviewPosted(Restaurant r, double rating, String reviewText) {
        RestaurantLibrary lib = new RestaurantLibrary();
        Review newReview = new Review(reviewText, rating);
        lib.addReviewToLibrary(newReview, r.id);
    }

    /*
     * Displays the review fragment for a restaurant when it is clicked in the search results.
     */
    @Override
    public void clickedRestaurant(Restaurant restaurant) {
        Log.d("Search", "CLicked!");
        mainView.displayFragment(new ReviewFragment(restaurant, this), true, "review");
    }

//    @Override
//    public void OnBackPressed() {
//        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
//        if (currentFragment != null && currentFragment.getTag() != null && !currentFragment.getTag().equals("main")) {
//            getSupportFragmentManager().popBackStack();
//        } else {
//            super.onBackPressed();
//        }
//    }
}