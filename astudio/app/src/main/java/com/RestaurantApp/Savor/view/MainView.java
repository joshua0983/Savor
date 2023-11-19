package com.RestaurantApp.Savor.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.RestaurantApp.Savor.databinding.ActivityMainBinding;


public class MainView extends AppCompatActivity implements IMainView {
    FragmentManager fmanager;
    ActivityMainBinding binding;
    public MainView(FragmentActivity activity) {
        this.fmanager = activity.getSupportFragmentManager();
        this.binding = ActivityMainBinding.inflate(activity.getLayoutInflater());
    }

    @Override
    public View getRootView() {
        return (View)this.binding.getRoot();
    }


    @Override
    public void displayFragment(Fragment fragment, boolean addToStack, String name) {
        FragmentTransaction ft = fmanager.beginTransaction();
        ft.replace(this.binding.fragmentContainerView.getId(), fragment);
        if (addToStack) ft.addToBackStack(name);
        ft.commit();
    }
}
