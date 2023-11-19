package intellij.view;

import intellij.model.SearchLocation;
import intellij.model.SearchName;
import intellij.model.SearchRating;
import intellij.model.Restaurant;
import intellij.model.RestaurantLibrary;
import intellij.model.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RestaurantApp {
    static Scanner in = new Scanner(System.in);
    static List<Restaurant> restaurants = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("RESTAURANT REVIEW APP - FIRST PROTOTYPE");
        while(true) {
            String searchParam;
            while (true) {
                System.out.print("Search for restaurant by NAME, LOCATION, or RATING: ");
                searchParam = in.next();
                if (searchParam.equalsIgnoreCase("name") || searchParam.equalsIgnoreCase("location") || searchParam.equalsIgnoreCase("rating")) {
                    break;
                } else {
                    System.out.println("Invalid");
                }
            }
            filterByParam(searchParam);
            if (restaurants.size() == 0) { //If no restaurants are found, start the search prompt over again.
                continue;
            }
            System.out.print("\nChoose which of these restaurant to rate, starting from 1: ");
            int pick = 1;
            int tempPick;
            while (true) {
                String input = in.next();
                try {
                    tempPick = Integer.parseInt(input);
                }
                catch(Exception e) {
                    System.out.println("Invalid selection");
                    System.out.print("Choose which of these restaurant to rate, starting from 1: ");
                    continue;
                }
                if (tempPick >= 1 && tempPick <= restaurants.size()) {
                    pick = tempPick;
                    break;
                } else {
                    System.out.println("Invalid selection");
                }
            }
            review(pick);
            System.out.println("Your review was added to " + restaurants.get(pick - 1).name);

            String nextAction;
            while (true) {
                System.out.print("\nSEARCH for another restaurant or QUIT? ");
                nextAction = in.next();
                if (nextAction.equalsIgnoreCase("quit")) {
                    System.out.print("Thanks! Happy dining!");
                    return;
                } else if (!(nextAction.equalsIgnoreCase("search"))) {
                    System.out.println("Invalid");
                }
                else {
                    System.out.println();
                    break;
                }
            }
        }
    }

    public static void filterByParam(String param) {

        if (param.equalsIgnoreCase("name")) { //searching by name
            System.out.print("Name of restaurant: ");
            String nameParam = in.next();
            System.out.println();
            SearchName searchByName = new SearchName(nameParam);
            restaurants = searchByName.search(RestaurantLibrary.library);

        } else if (param.equalsIgnoreCase("location")) { //searching by location
            //for prototype purposes, the user's current coordinates are inputted manually
            double latParam;
            double longParam;
            double radiusParam;
            while(true) {
                System.out.print("Current latitude: ");
                try {
                    String input = in.next();
                    latParam = Double.parseDouble(input);
                    break;
                } catch(Exception e) {
                    System.out.println("Invalid input");
                }
            }
            while(true) {
                System.out.print("Current longitude: ");
                try {
                    String input = in.next();
                    longParam = Double.parseDouble(input);
                    break;
                } catch(Exception e) {
                    System.out.println("Invalid input");
                }
            }
            while(true) {
                System.out.print("Radius to search within (km): ");
                try {
                    String input = in.next();
                    radiusParam = Double.parseDouble(input);
                    break;
                } catch(Exception e) {
                    System.out.println("Invalid input");
                }
            }
            System.out.println();
            SearchLocation searchByLocation = new SearchLocation(latParam, longParam, radiusParam);
            restaurants = searchByLocation.search(RestaurantLibrary.library);
        } else { //searching by rating
            double ratingParam;
            while(true) {
                System.out.print("Minimum rating from 0-5: ");
                try {
                    String input = in.next();
                    ratingParam = Double.parseDouble(input);
                    break;
                } catch(Exception e) {
                    System.out.println("Invalid input");
                }
            }
            System.out.println();
            SearchRating searchByRating = new SearchRating(ratingParam);
            restaurants = searchByRating.search(RestaurantLibrary.library);
        }
    }

    public static void review(int pick) {
        double rat;
        System.out.println("You have picked: " + restaurants.get(pick - 1));
        //catches if the rating is not a number or not within 0-5
        while(true) {
            System.out.print("Enter your rating from 0-5 stars: ");
            try {
                String input = in.next();
                rat = Double.parseDouble(input);
                if (rat < 0 || rat > 5) {
                    System.out.println("Invalid input, rating out of bounds");
                }
                else { break;}
            } catch(Exception e) {
                System.out.println("Invalid input");
            }
        }
        System.out.print("Write your review: ");
        String rev = in.next();
        Review newReview = new Review(rev, rat);
        restaurants.get(pick - 1).addReview(newReview);

    }
}