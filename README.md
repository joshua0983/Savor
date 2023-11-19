# Iteration 3 Functionality
This iteration implements mostly the same features as our last iteration, but ported onto Android Studio 
with a cleaner and more intuitive UI. From the starting screen, the user has the option to search for
a restaurant by name, maximum distance in km, or minimum rating from 0-5 stars. After inputting
their search, a scrollable list of restaurants matching the search criteria will appear. Tapping on
a restaurant takes the user to the reviewing page, which displays past reviews of the selected restaurant
and prompts the user to write their own. The user can choose a star rating from 0-5 and write a review, or
can click the back button to return to the searching page. Clicking the post button will save the user's
review into that restaurant's list of reviews, as well as update the average rating of the restaurant.
This then leads back to the search page, where the process can be repeated.

# User notes/limitations
* For testing purposes, our restaurant library contains only a handful of restaurants in the 
Poughkeepsie/Arlington area.
* Similarly, each restaurant has been populated with manually written reviews to simulate the social
networking aspect, which is not yet implemented.
* The user's location is currently hardcoded as Main Building at Vassar College so that the restaurants, 
which are all nearby, can appear when searching by location.
* As of now, data is not stored between uses of the app.