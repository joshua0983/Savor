# Search for Restaurants

## 1. Primary actor and goals

* __User__: Search for restaurants.

## 2. Other stakeholders and their goals

* __Friends__: Already given a rating for a restaurant that is being sorted


## 3. Preconditions
 
* Restaurants need to be registered.
* The search conditions are defined.

## 4. Postconditions

* The review is posted and saved.
* The user's can access the review.
* Sorting conditions are reset so they can be reconfigured later

## 5. Workflow

* Display restaurant near the user
* User checks reviews of restaurants
* User sorts the restaurants
* Restaurants are displayed based on preference
* User sees review

```plantuml
@startuml

skin rose

title Search Restaurant (Brief level)

'define the lanes
|#gold|User|
|#violet|System|

start


|System|
:Prompts user to search for restaurants;

|User|
:User checks reviews 
of restaurants;

|User|
:User chooses to sort by Rating, location or name;

if (Rating) then (yes)
    |System|
    :Give restaurant sorting by rating. 
    Highest rated restaurants show
    up at the top;
(No) elseif (Location) then (yes)
    |System|
    :Give restaurant sorting by location.
    Nearest located restaurant first;
(No) elseif (Name) then (yes)
    |System|
    :Give restaurant sorting by name.
    Restaurant closest to the input name is first;
    
endif

|System|
:Displays reviews that users friends 
have given the restaurants;



|User|

:Eats at the restaurant;

:User shares review 
on the app (Specifying star rating);


|System|
:The review gets posted;
:;

@enduml
```


