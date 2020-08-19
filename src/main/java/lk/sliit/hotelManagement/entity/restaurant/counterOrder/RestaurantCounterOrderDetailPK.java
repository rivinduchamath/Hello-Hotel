package lk.sliit.hotelManagement.entity.restaurant.counterOrder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RestaurantCounterOrderDetailPK implements Serializable {

    private String foodItemId;
    private  String restaurantCounterOrderId;

    public RestaurantCounterOrderDetailPK(String foodItemId, String restaurantCounterOrderId) {
        this.foodItemId = foodItemId;
        this.restaurantCounterOrderId = restaurantCounterOrderId;
    }

    public RestaurantCounterOrderDetailPK() {
    }

    public String getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(String foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getRestaurantCounterOrderId() {
        return restaurantCounterOrderId;
    }

    public void setRestaurantCounterOrderId(String restaurantCounterOrderId) {
        this.restaurantCounterOrderId = restaurantCounterOrderId;
    }

    @Override
    public String toString() {
        return "RestaurantCounterOrderDetailPK{" +
                "foodItemId='" + foodItemId + '\'' +
                ", restaurantCounterOrderId='" + restaurantCounterOrderId + '\'' +
                '}';
    }
}
