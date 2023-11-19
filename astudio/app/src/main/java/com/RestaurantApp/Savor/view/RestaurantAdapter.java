package com.RestaurantApp.Savor.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.RestaurantApp.Savor.R;
import com.RestaurantApp.Savor.model.Restaurant;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> implements IRestaurantAdapter {
    Context context;
    private List<Restaurant> restaurantList;
    ISearchView.Listener listener;


    public RestaurantAdapter(Context context, List<Restaurant> restaurantList, ISearchView.Listener listener) {
        this.context = context;
        this.restaurantList = restaurantList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RestaurantViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        final Restaurant restaurant = restaurantList.get(position);
        holder.restaurantNameTextView.setText(restaurant.getName());
        holder.restaurantNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.clickedRestaurant(restaurant);
            }
        });
    }


    @Override
    public int getItemCount() {
        return restaurantList.size();
    }


    static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        private TextView restaurantNameTextView;
        private TextView restaurantRatingTextView;
        // Add other TextViews for other restaurant details

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            restaurantNameTextView = itemView.findViewById(R.id.restaurant_name);
//            restaurantRatingTextView = itemView.findViewById(R.id.)
            // restaurantNameTextView.setOnClickListener();
            // Initialize other TextViews here
        }


    }

}
