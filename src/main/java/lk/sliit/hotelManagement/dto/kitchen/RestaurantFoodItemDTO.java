package lk.sliit.hotelManagement.dto.kitchen;

public class RestaurantFoodItemDTO {

    int foodItemId;
    int orderId;
    String foodName;
    double quantity;
    double price;
    double totalPrice;
    double sellingRateOnline;
    double sellingRateCounter;

    public RestaurantFoodItemDTO() {
    }

    public RestaurantFoodItemDTO(int foodItemId, int orderId, String foodName, double quantity, double price) {
        this.foodItemId = foodItemId;
        this.orderId = orderId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    //use to generate kitchen report
    public RestaurantFoodItemDTO(int foodItemId, String foodName, double quantity,
                                 double price, double totalPrice, double sellingRateOnline, double sellingRateCounter) {
        this.foodItemId = foodItemId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.sellingRateOnline = sellingRateOnline;
        this.sellingRateCounter = sellingRateCounter;
    }

    public RestaurantFoodItemDTO(int foodItemId, String foodName, double quantity, double price) {
        this.foodItemId = foodItemId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getSellingRateOnline() {
        return sellingRateOnline;
    }

    public void setSellingRateOnline(double sellingRateOnline) {
        this.sellingRateOnline = sellingRateOnline;
    }

    public double getSellingRateCounter() {
        return sellingRateCounter;
    }

    public void setSellingRateCounter(double sellingRateCounter) {
        this.sellingRateCounter = sellingRateCounter;
    }
}
