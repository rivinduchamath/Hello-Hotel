package lk.sliit.employeeManagement.entity.restaurant.onlineOrder;

import lk.sliit.employeeManagement.entity.kitchen.FoodItem;

import javax.persistence.*;

@Entity
public class RestaurantOnlineOrderDetails {
    @EmbeddedId
    private RestaurantOnlineOrderDetailsPK restaurantOnlineOrderDetailsPK;
   private double quantity;
   private double unitePrice;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "restaurantOnlineOrderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private RestaurantOnlineOrder restaurantOnlineOrder;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "foodItemId", referencedColumnName = "itemId", insertable = false, updatable = false)
    private FoodItem foodItem;


    public RestaurantOnlineOrderDetails(RestaurantOnlineOrderDetailsPK restaurantOnlineOrderDetailsPK, double quantity, double unitePrice) {
        this.restaurantOnlineOrderDetailsPK = restaurantOnlineOrderDetailsPK;
        this.quantity = quantity;
        this.unitePrice = unitePrice;

    }

    public RestaurantOnlineOrderDetails(String restaurantOnlineOrderId, String foodItemId ,double quantity, double unitePrice) {
        this.restaurantOnlineOrderDetailsPK = new RestaurantOnlineOrderDetailsPK(restaurantOnlineOrderId,foodItemId);
        this.quantity = quantity;
        this.unitePrice = unitePrice;

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
