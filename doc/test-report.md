# Testing

* The searching and reviewing functions were tested with as many inputs
as possible to ensure that no mistakes could be made by the system.

* Tests were also made to ensure that the system saved the reviews
posted to a specific restaurant.

* Our only unresolved issue is related to searching by location, due to the
complexity of the haversine method we used to calculate radius of
two coordinates. We plan to resolve this in our next iteration.

# Test that shows review being saved to a certain restaurant after posting
```Java
Search for restaurant by NAME, LOCATION, or RATING: name
Name of restaurant: mc

1. McDonald's, 733 Main St, 3.6 stars
   No reviews posted.

Choose which of these restaurant to rate, starting from 1: 1
You have picked: McDonald's, 733 Main St, 3.6 stars
Enter your rating from 0-5 stars: 4
Write your review: Good!
Your review was added to McDonald's

SEARCH for another restaurant or QUIT? search

Search for restaurant by NAME, LOCATION, or RATING: rating
Minimum rating from 0-5: 3

1. Gordon Commons (The Deece), 124 Raymond Ave, 3.9 stars
   No reviews posted.
2. Pizzeria Bacio, 7 Collegeview Ave, 4.4 stars
   No reviews posted.
3. Thai Spice, 28 Raymond Ave, 4.1 stars
   No reviews posted.
4. Wendy's, 753 Main St, 3.8 stars
   No reviews posted.
5. McDonald's, 733 Main St, 3.8 stars
   4.0: Good!
6. Shadows on the Hudson, 176 Rinaldi Blvd, 4.5 stars
   No reviews posted.
```

# Test that shows exceptions being caught
```Java
Search for restaurant by NAME, LOCATION, or RATING: fail
Invalid
Search for restaurant by NAME, LOCATION, or RATING: name
Name of restaurant: fail

No restaurants found
Search for restaurant by NAME, LOCATION, or RATING: name
Name of restaurant: mc

1. McDonald's, 733 Main St, 3.6 stars
   No reviews posted.

Choose which of these restaurant to rate, starting from 1: fail
Invalid selection
Choose which of these restaurant to rate, starting from 1: 1
You have picked: McDonald's, 733 Main St, 3.6 stars
Enter your rating from 0-5 stars: fail
Invalid input
Enter your rating from 0-5 stars: 2
Write your review: Fine.
Your review was added to McDonald's

SEARCH for another restaurant or QUIT? fail
Invalid

SEARCH for another restaurant or QUIT? search

Search for restaurant by NAME, LOCATION, or RATING: rating
Minimum rating from 0-5: fail
Invalid input
Minimum rating from 0-5: 3.5

1. Gordon Commons (The Deece), 124 Raymond Ave, 3.9 stars
   No reviews posted.
2. Pizzeria Bacio, 7 Collegeview Ave, 4.4 stars
   No reviews posted.
3. Thai Spice, 28 Raymond Ave, 4.1 stars
   No reviews posted.
4. Wendy's, 753 Main St, 3.8 stars
   No reviews posted.
5. Shadows on the Hudson, 176 Rinaldi Blvd, 4.5 stars
   No reviews posted.

Choose which of these restaurant to rate, starting from 1: 1
You have picked: Gordon Commons (The Deece), 124 Raymond Ave, 3.9 stars
Enter your rating from 0-5 stars: 1
Write your review: Poor!
Your review was added to Gordon Commons (The Deece)

SEARCH for another restaurant or QUIT? quit
Thanks! Happy dining!
```
# The unresolved issue with location searching
```Java
Search for restaurant by NAME, LOCATION, or RATING: location
Current latitude: 41.69024
Current longitude: -73.89556
Radius to search within (km): 4000

No restaurants found

```