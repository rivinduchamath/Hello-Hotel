package lk.sliit.hotelManagement.entity.restaurant.counterOrder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RestaurantCounterOrderDetailPK implements Serializable {

    private String foodItemId;
    private  int restaurantCounterOrder;

    public RestaurantCounterOrderDetailPK(String foodItemId, int restaurantCounterOrder) {
        this.foodItemId = foodItemId;
        this.restaurantCounterOrder = restaurantCounterOrder;
    }

    public RestaurantCounterOrderDetailPK() {
    }

    public String getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(String foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getRestaurantCounterOrderId() {
        return restaurantCounterOrder;
    }

    public void setRestaurantCounterOrderId(int restaurantCounterOrderId) {
        this.restaurantCounterOrder = restaurantCounterOrderId;
    }

    @Override
    public String toString() {
        return "RestaurantCounterOrderDetailPK{" +
                "foodItemId='" + foodItemId + '\'' +
                ", restaurantCounterOrder='" + restaurantCounterOrder + '\'' +
                '}';
    }
}
