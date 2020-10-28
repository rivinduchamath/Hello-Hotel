package lk.sliit.hotelManagement.dto.kitchen;

public class RestaurantFoodOrderDTO {

    int foodItemID;
    int orderId;
    String type;
    double quantity;
    String foodName;
    String state;
    String button;
    int index;
    int oldOrderId;

    public RestaurantFoodOrderDTO() {
    }

    public RestaurantFoodOrderDTO(int foodItemID, int orderId, String type, double quantity, String foodName, String state, String button, int index) {
        this.foodItemID = foodItemID;
        this.orderId = orderId;
        this.type = type;
        this.quantity = quantity;
        this.foodName = foodName;
        this.state = state;
        this.button = button;
        this.index = index;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getOldOrderId() {
        return oldOrderId;
    }

    public void setOldOrderId(int oldOrderId) {
        this.oldOrderId = oldOrderId;
    }
}
