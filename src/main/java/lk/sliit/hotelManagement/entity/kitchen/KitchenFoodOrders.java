package lk.sliit.hotelManagement.entity.kitchen;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class KitchenFoodOrders implements Serializable {
    @Id
    private int orderId;
    private int foodItemId;
    private String description;
    private double amount;
    private Date expectedDate;

    public KitchenFoodOrders(int orderId, int foodItemId, String description, double amount, Date expectedDate) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
        this.description = description;
        this.amount = amount;
        this.expectedDate = expectedDate;
    }

    public KitchenFoodOrders() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }


}
