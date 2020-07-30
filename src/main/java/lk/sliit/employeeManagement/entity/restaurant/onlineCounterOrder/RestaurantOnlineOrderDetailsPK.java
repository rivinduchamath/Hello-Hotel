package lk.sliit.employeeManagement.entity.restaurant.onlineCounterOrder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RestaurantOnlineOrderDetailsPK implements Serializable {

    private String foodItemId;
    private  String restaurantOnlineOrderId;

    public RestaurantOnlineOrderDetailsPK(String foodItemId, String restaurantOnlineOrderId) {
        this.foodItemId = foodItemId;
        this.restaurantOnlineOrderId = restaurantOnlineOrderId;
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
        return restaurantOnlineOrderId;
    }

    public void setRestaurantOnlineOrderId(String restaurantOnlineOrderId) {
        this.restaurantOnlineOrderId = restaurantOnlineOrderId;
    }

    @Override
    public String toString() {
        return "RestaurantOnlineOrderDetailsPK{" +
                "foodItemId='" + foodItemId + '\'' +
                ", restaurantOnlineOrderId='" + restaurantOnlineOrderId + '\'' +
                '}';
    }
}
