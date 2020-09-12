package lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder;



public class RestaurantOnlineOrderDetailsDTO {
    private String restaurantOnlineOrder;
    private int foodItem;
    private double quantity;
    private double unitePrice;

    public RestaurantOnlineOrderDetailsDTO(String restaurantOnlineOrder, int foodItem, double quantity, double unitePrice) {
        this.restaurantOnlineOrder = restaurantOnlineOrder;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.unitePrice = unitePrice;
    }

    public RestaurantOnlineOrderDetailsDTO() {
    }

    public String getRestaurantOnlineOrder() {
        return restaurantOnlineOrder;
    }

    public void setRestaurantOnlineOrder(String restaurantOnlineOrder) {
        this.restaurantOnlineOrder = restaurantOnlineOrder;
    }

    public int getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(int foodItem) {
        this.foodItem = foodItem;
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

    @Override
    public String toString() {
        return "RestaurantOnlineOrderDetailsDTO{" +
                "foodItem='" + foodItem + '\'' +
                ", quantity=" + quantity +
                ", unitePrice=" + unitePrice +
                '}';
    }
}
