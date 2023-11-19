package com.RestaurantApp.Savor.view;
import androidx.activity.OnBackPressedCallback;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.RestaurantApp.Savor.R;
import com.RestaurantApp.Savor.databinding.FragmentSearchBinding;
import com.RestaurantApp.Savor.model.Restaurant;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements ISearchView, OnItemClickListener {
    FragmentSearchBinding binding;
    Listener listener;
    private int flag = -1;
    String param = "";
    private List<Restaurant> restaurantList = new ArrayList<>();


    public SearchFragment(@NonNull Listener listener){
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentSearchBinding.inflate(inflater);
        return this.binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SearchLogs", "Go button clicked");
                param = SearchFragment.this.binding.searchParam.getText().toString();
                if (flag == 0) {
                    SearchFragment.this.listener.searchByName(param, SearchFragment.this);
                } else if (flag == 1) {
                    try {
                        double paramAsDouble = Double.parseDouble(param);
                        SearchFragment.this.listener.searchByLocation(paramAsDouble, SearchFragment.this);
                    } catch (NumberFormatException e) {
                        String errorMsg = v.getContext().getString(R.string.search_location_error);
                        Snackbar.make(v, errorMsg, Snackbar.LENGTH_LONG).show();
                    }
                } else if (flag == 2) {
                    try {
                        double paramAsDouble = Double.parseDouble(param);
                        SearchFragment.this.listener.searchByRating(paramAsDouble, SearchFragment.this);
                    } catch (NumberFormatException e) {
                        String errorMsg = v.getContext().getString(R.string.search_rating_error);
                        Snackbar.make(v, errorMsg, Snackbar.LENGTH_LONG).show();
                    }

                } else {
                    String errorMsg = v.getContext().getString(R.string.search_error);
                    Snackbar.make(v, errorMsg, Snackbar.LENGTH_LONG).show();
                }
                Log.d("SearchLogs", "Go button clicked!");
            }

        }
        );

        this.binding.searchParameters.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                String buttonText = (String) radioButton.getText();
                Log.d("ButtonTextLogs", "Button Text: " + buttonText);
                if (buttonText.equalsIgnoreCase("Restaurant name")) {
                    flag = 0; //searching by name
                } else if (buttonText.equalsIgnoreCase("Maximum distance (km)")) {
                    flag = 1; //searching by loc
                } else {
                    flag = 2; //searching by rating
                }
            }
        });
        }

        public void onItemClick(Restaurant restaurant){
            listener.clickedRestaurant(restaurant);
        }

    @Override
    public void displayResults(List<Restaurant> searchResults) {
//        Log.d("SearchFragmentLogs", "Displaying search results: " + searchResults.size());
  //      restaurantList.clear();
    //    restaurantList.addAll(searchResults);
      //  adapter.notifyDataSetChanged();
        //Log.d("SearchLogs", "Number of restaurants: " + restaurantList.size());

        this.binding.resultsView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        this.binding.resultsView.setAdapter(new RestaurantAdapter(this.getContext(), searchResults, listener));
    }


}
