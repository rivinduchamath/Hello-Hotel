package lk.sliit.employeeManagement.entity.restaurant.counterOrder;


import lk.sliit.employeeManagement.entity.kitchen.FoodItem;

import javax.persistence.*;

@Entity
public class RestaurantCounterOrderDetail {

    @EmbeddedId
    private RestaurantCounterOrderDetailPK restaurantCounterOrderDetailPK;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "restaurantCounterOrderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private RestaurantCounterOrder restaurantCounterOrder;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "foodItemId", referencedColumnName = "itemId", insertable = false, updatable = false)
    private FoodItem foodItem;


    public RestaurantCounterOrderDetail(RestaurantCounterOrderDetailPK restaurantCounterOrderDetailPK) {
        this.restaurantCounterOrderDetailPK = restaurantCounterOrderDetailPK;
    }

    public RestaurantCounterOrderDetail( String restaurantCounterOrderId,String foodItemId ) {
        this.restaurantCounterOrderDetailPK = new RestaurantCounterOrderDetailPK(restaurantCounterOrderId,foodItemId);
    }

    public RestaurantCounterOrderDetail() {
    }

    public RestaurantCounterOrderDetailPK getRestaurantCounterOrderDetailPK() {
        return restaurantCounterOrderDetailPK;
    }

    public void setRestaurantCounterOrderDetailPK(RestaurantCounterOrderDetailPK restaurantCounterOrderDetailPK) {
        this.restaurantCounterOrderDetailPK = restaurantCounterOrderDetailPK;
    }

    public RestaurantCounterOrder getRestaurantCounterOrder() {
        return restaurantCounterOrder;
    }

    public void setRestaurantCounterOrder(RestaurantCounterOrder restaurantCounterOrder) {
        this.restaurantCounterOrder = restaurantCounterOrder;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
