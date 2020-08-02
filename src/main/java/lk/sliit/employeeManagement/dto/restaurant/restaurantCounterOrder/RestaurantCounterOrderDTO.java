package lk.sliit.employeeManagement.dto.restaurant.restaurantCounterOrder;

import java.sql.Date;

public class RestaurantCounterOrderDTO {
    private String orderId;
    private String orderState;
    private double quantity;
    private Date date;
    private String customerId;

    public RestaurantCounterOrderDTO(String orderId, String orderState, double quantity, Date date, String customerId) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.quantity = quantity;
        this.date = date;
        this.customerId = customerId;
    }

    public RestaurantCounterOrderDTO() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "RestaurantCounterOrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderState='" + orderState + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
