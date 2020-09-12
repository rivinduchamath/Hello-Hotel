package lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder;

import java.util.Date;

public class RestaurantCounterOrderDTO {
    private int orderId;
    private String orderState;
    private double quantity;
    private Date date;
    private String dataValue;
    private int customerId;
    private int orderHolder;

    public RestaurantCounterOrderDTO(int orderId, String orderState, double quantity,
                                     Date date, String dataValue, int customerId,
                                     int orderHolder) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.quantity = quantity;
        this.date = date;
        this.dataValue = dataValue;
        this.customerId = customerId;
        this.orderHolder = orderHolder;
    }

    public RestaurantCounterOrderDTO(int orderId, String orderState,
                                     double quantity, Date date, String dataValue,
                                     int customerId) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.quantity = quantity;
        this.date = date;
        this.dataValue = dataValue;
        this.customerId = customerId;
    }

    public RestaurantCounterOrderDTO() {
    }

    public RestaurantCounterOrderDTO(int orderId) {      this.orderId = orderId;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public int getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(int orderHolder) {
        this.orderHolder = orderHolder;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "RestaurantCounterOrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderState='" + orderState + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", dataValue='" + dataValue + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
