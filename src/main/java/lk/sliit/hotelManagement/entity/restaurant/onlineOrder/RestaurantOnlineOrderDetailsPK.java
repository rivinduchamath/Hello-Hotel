package lk.sliit.hotelManagement.entity.restaurant.onlineOrder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RestaurantOnlineOrderDetailsPK implements Serializable {

    private int foodItemId;
    private  int restaurantOnlineOrder;

    public RestaurantOnlineOrderDetailsPK(int foodItemId, int restaurantOnlineOrder) {
        this.foodItemId = foodItemId;
        this.restaurantOnlineOrder = restaurantOnlineOrder;
    }

    public RestaurantOnlineOrderDetailsPK() {
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getRestaurantOnlineOrderId() {
        return restaurantOnlineOrder;
    }

    public void setRestaurantOnlineOrderId(int restaurantOnlineOrderId) {
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
