package lk.sliit.hotelManagement.entity.restaurant.onlineOrder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RestaurantOnlineOrderDetailsPK implements Serializable {

    private String foodItemId;
    private  String restaurantOnlineOrder;

    public RestaurantOnlineOrderDetailsPK(String foodItemId, String restaurantOnlineOrder) {
        this.foodItemId = foodItemId;
        this.restaurantOnlineOrder = restaurantOnlineOrder;
    }

    public RestaurantOnlineOrderDetailsPK() {
    }

    public String getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(String foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getRestaurantOnlineOrderId() {
        return restaurantOnlineOrder;
    }

    public void setRestaurantOnlineOrderId(String restaurantOnlineOrderId) {
        this.restaurantOnlineOrder = restaurantOnlineOrderId;
    }

    @Override
    public String toString() {
        return "RestaurantOnlineOrderDetailsPK{" +
                "foodItemId='" + foodItemId + '\'' +
                ", restaurantOnlineOrder='" + restaurantOnlineOrder + '\'' +
                '}';
    }
}
