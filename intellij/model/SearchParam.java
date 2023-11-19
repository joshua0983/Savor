package intellij.model;

public class SearchParam {

    public void searchByParam(String param) {
        while (true) {
            System.out.print("Search for restaurant by NAME, LOCATION, or RATING: ");
            if (param.equalsIgnoreCase("name") || param.equalsIgnoreCase("location") || param.equalsIgnoreCase("rating")) {
                break;
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
