package Geekster.Restaurant.models;

public class Restaurant {

    private String id;
    private String restaurantName;
    private boolean restaurantStatus;

    public Restaurant(String id, String restaurantName, boolean restaurantStatus) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.restaurantStatus = restaurantStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public boolean isRestaurantStatus() {
        return restaurantStatus;
    }

    public void setRestaurantStatus(boolean restaurantStatus) {
        this.restaurantStatus = restaurantStatus;
    }
}
