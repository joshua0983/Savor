# Functionality
This prototype implements the functionality for searching for a restaurant, and
writing a review of a restaurant. The search parameters are by name, location, or rating. If searching by name, 
the results will be restaurants whose names contain the search parameter. If searching by
location, the results are restaurants within the specified radius of
the user's current location. If searching by rating, the results are restaurants
with a higher average rating than the search parameter. 

After obtaining search results, the user is prompted to choose which restaurant of the
results they want to create a review for. They are prompted to enter a rating from 0 to 5
and to write the text of their review. After this, the review is saved and attached to the restaurant,
and its average star rating is updated. Finally, the user can choose to repeat
this process on a new restaurant, or exit the program.

# Limitations
* For simple testing purposes, our restaurant library contains only
a handful of restaurants in the Poughkeepsie/Arlington area.
* Current latitude and longitude must be manually entered by the user.

# Running
* The main method is located in the RestaurantApp class.
* Any inputs that are not recognized will be rejected and you
will be asked to re-enter it. (For example, typing "five" instead
of "5" for a rating)
* To find restaurants using location search, note that Vassar's
coordinates