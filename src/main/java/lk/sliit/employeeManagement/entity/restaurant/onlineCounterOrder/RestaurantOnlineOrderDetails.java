package lk.sliit.employeeManagement.entity.restaurant.onlineCounterOrder;

import lk.sliit.employeeManagement.entity.kitchen.FoodItem;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetailPK;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantOnlineOrderDetails {
    @EmbeddedId
    private RestaurantOnlineOrderDetailsPK restaurantOnlineOrderDetailsPK;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "restaurantOnlineOrderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private RestaurantOnlineOrder restaurantOnlineOrder;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "foodItemId", referencedColumnName = "itemId", insertable = false, updatable = false)
    private FoodItem foodItem;


    public RestaurantOnlineOrderDetails(RestaurantOnlineOrderDetailsPK restaurantOnlineOrderDetailsPK, RestaurantOnlineOrder restaurantOnlineOrder, FoodItem foodItem) {
        this.restaurantOnlineOrderDetailsPK = restaurantOnlineOrderDetailsPK;
        this.restaurantOnlineOrder = restaurantOnlineOrder;
        this.foodItem = foodItem;
    }
    public RestaurantOnlineOrderDetails( String restaurantOnlineOrderId,String foodItemId ) {
        this.restaurantOnlineOrderDetailsPK = new RestaurantOnlineOrderDetailsPK(restaurantOnlineOrderId,foodItemId);

    }

    public RestaurantOnlineOrderDetails() {
    }


    public RestaurantOnlineOrderDetailsPK getRestaurantOnlineOrderDetailsPK() {
        return restaurantOnlineOrderDetailsPK;
    }

    public void setRestaurantOnlineOrderDetailsPK(RestaurantOnlineOrderDetailsPK restaurantOnlineOrderDetailsPK) {
        this.restaurantOnlineOrderDetailsPK = restaurantOnlineOrderDetailsPK;
    }

    public RestaurantOnlineOrder getRestaurantOnlineOrder() {
        return restaurantOnlineOrder;
    }

    public void setRestaurantOnlineOrder(RestaurantOnlineOrder restaurantOnlineOrder) {
        this.restaurantOnlineOrder = restaurantOnlineOrder;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
