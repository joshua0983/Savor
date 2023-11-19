package Savor.example.Savor;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.contrib.RecyclerViewActions;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.RestaurantApp.Savor.R;
import com.RestaurantApp.Savor.controller.MainActivity;
//import androidx.test.espresso.contrib.RatingBarActions;

@RunWith(AndroidJUnit4.class)
public class SystemTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSearchTyping() {
        ViewInteraction viSearchText = Espresso.onView(ViewMatchers.withId(R.id.searchParam));
        /*viSearchText.check(
                ViewAssertions.matches(
                        ViewMatchers.withText(R.string.)));*/
        ViewInteraction viSearch = Espresso.onView(ViewMatchers.withId(R.id.searchParam));
        viSearch.perform(ViewActions.typeText("deece"));
        Espresso.closeSoftKeyboard();

        Espresso.onView(ViewMatchers.withId(R.id.nameButton)).perform(ViewActions.click());
        viSearchText.check(
                ViewAssertions.matches(
                        ViewMatchers.withSubstring("deece")));
    }

    @Test
    public void testSearching() {
        testSearchTyping();
        Espresso.onView(ViewMatchers.withText(R.string.search_button))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.resultsView)).perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));
    }

    @Test
    public void testReviewing() {
        testSearching();

        // Write a comment in an EditText
        Espresso.onView(ViewMatchers.withId(R.id.reviewText))
                .perform(ViewActions.typeText("Great place!"));

        // Rate on a RatingBar
//        Espresso.onView(ViewMatchers.withId(R.id.ratingBar))
//                .perform(ViewActions.(4.5f));

        // Click the "Post" button
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.postButton))
                .perform(ViewActions.click());

    }
}
