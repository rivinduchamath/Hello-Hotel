package lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder;



public class RestaurantCounterOrderDetailDTO {


    private String foodItem;
    private double quantity;
    private double unitePrice;

    public RestaurantCounterOrderDetailDTO( String foodItem, double quantity, double unitePrice) {

        this.foodItem = foodItem;
        this.quantity = quantity;
        this.unitePrice = unitePrice;
    }

    public RestaurantCounterOrderDetailDTO() {
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
                "foodItem='" + foodItem + '\'' +
                ", quantity=" + quantity +
                ", unitePrice=" + unitePrice +
                '}';
    }
}
