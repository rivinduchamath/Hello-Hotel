package lk.sliit.hotelManagement.dto.kitchen;

import java.util.List;

public class RestaurantFoodOrderDTO {

    int orderId;
    String type;
    String state;
    String button;
    List<RestaurantFoodItemDTO> foodItems;
    int index;

    public RestaurantFoodOrderDTO() {
    }

    public RestaurantFoodOrderDTO(int orderId, String type, String state, String button, List<RestaurantFoodItemDTO> foodItems) {
        this.orderId = orderId;
        this.type = type;
        this.state = state;
        this.button = button;
        this.foodItems = foodItems;
    }

    public RestaurantFoodOrderDTO(int orderId, String type, List<RestaurantFoodItemDTO> foodItems) {
        this.orderId = orderId;
        this.type = type;
        this.foodItems = foodItems;
    }

    public RestaurantFoodOrderDTO(int orderId, String type, String state, String button, List<RestaurantFoodItemDTO> foodItems, int index) {
        this.orderId = orderId;
        this.type = type;
        this.state = state;
        this.button = button;
        this.foodItems = foodItems;
        this.index = index;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public List<RestaurantFoodItemDTO> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<RestaurantFoodItemDTO> foodItems) {
        this.foodItems = foodItems;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
