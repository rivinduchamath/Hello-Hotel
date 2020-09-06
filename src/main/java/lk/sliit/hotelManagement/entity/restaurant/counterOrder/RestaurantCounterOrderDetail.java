package lk.sliit.hotelManagement.entity.restaurant.counterOrder;


import lk.sliit.hotelManagement.entity.kitchen.FoodItem;

import javax.persistence.*;

@Entity
public class RestaurantCounterOrderDetail {

    @EmbeddedId
    private RestaurantCounterOrderDetailPK restaurantCounterOrderDetailPK;
    private double quantity;
    private double unitePrice;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "restaurantCounterOrderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private RestaurantCounterOrder restaurantCounterOrder;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "foodItemId", referencedColumnName = "itemId",nullable = true,insertable = false, updatable = false)
    private FoodItem foodItem;


    public RestaurantCounterOrderDetail(RestaurantCounterOrderDetailPK restaurantCounterOrderDetailPK, double quantity, double unitePrice) {
        this.restaurantCounterOrderDetailPK = restaurantCounterOrderDetailPK;
        this.quantity = quantity;
        this.unitePrice = unitePrice;

    }

    public RestaurantCounterOrderDetail(String restaurantCounterOrderId, String foodItemId, double quantity, double unitePrice) {
        this.restaurantCounterOrderDetailPK = new RestaurantCounterOrderDetailPK(restaurantCounterOrderId, foodItemId);
        this.quantity = quantity;
        this.unitePrice = unitePrice;

    }

    public RestaurantCounterOrderDetail() {
    }

    public double getQuantity() {
        return quantity;
    }


    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
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
