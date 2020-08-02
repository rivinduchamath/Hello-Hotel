package lk.sliit.employeeManagement.dto.restaurant.restaurantCounterOrder;



public class RestaurantCounterOrderDetailDTO {

    private String restaurantCounterOrder;
    private String foodItem;
    private double quantity;
    private double unitePrice;

    public RestaurantCounterOrderDetailDTO(String restaurantCounterOrder, String foodItem, double quantity, double unitePrice) {
        this.restaurantCounterOrder = restaurantCounterOrder;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.unitePrice = unitePrice;
    }

    public RestaurantCounterOrderDetailDTO() {
    }

    public String getRestaurantCounterOrder() {
        return restaurantCounterOrder;
    }

    public void setRestaurantCounterOrder(String restaurantCounterOrder) {
        this.restaurantCounterOrder = restaurantCounterOrder;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
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
        return "RestaurantCounterOrderDetailDTO{" +
                "restaurantCounterOrder='" + restaurantCounterOrder + '\'' +
                ", foodItem='" + foodItem + '\'' +
                ", quantity=" + quantity +
                ", unitePrice=" + unitePrice +
                '}';
    }
}
