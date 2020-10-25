package lk.sliit.hotelManagement.dto.kitchen;

import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;

import java.sql.Date;

public class KitchenFoodOrderDTO {

    private int orderId;
    private int foodItemId;
    private String description;
    private double amount;
    private Date expectedDate;

    public KitchenFoodOrderDTO() {
    }

    public KitchenFoodOrderDTO(int foodItemId, String description, double amount, Date expectedDate) {
        this.foodItemId = foodItemId;
        this.description = description;
        this.amount = amount;
        this.expectedDate = expectedDate;
    }

    public KitchenFoodOrderDTO(int orderId, int foodItemId, String description, double amount, Date expectedDate) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
        this.description = description;
        this.amount = amount;
        this.expectedDate = expectedDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }


}
