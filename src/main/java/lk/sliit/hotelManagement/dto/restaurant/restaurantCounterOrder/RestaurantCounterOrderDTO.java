package lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder;

import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestaurantCounterOrderDTO {
    private int orderId;
    private String orderState;
    private String foodName;
    private double quantity;
    private Date date;
    private String dataValue;
    private int customerId;
    private int orderHolder;
    private List<RestaurantCounterOrderDetailDTO> orderDetails = new ArrayList<>();

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

    public RestaurantCounterOrderDTO(int orderId, String orderState, double quantity, Date date, String dataValue,
                                     int customerId, int orderHolder, List<RestaurantCounterOrderDetailDTO> orderDetails) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.quantity = quantity;
        this.date = date;
        this.dataValue = dataValue;
        this.customerId = customerId;
        this.orderHolder = orderHolder;
        this.orderDetails = orderDetails;
    }

    public RestaurantCounterOrderDTO() {
    }

    public RestaurantCounterOrderDTO(int orderId, String orderState, String foodName, double quantity, Date date,
                                     String dataValue, int customerId, int orderHolder, List<RestaurantCounterOrderDetailDTO> orderDetails) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.foodName = foodName;
        this.quantity = quantity;
        this.date = date;
        this.dataValue = dataValue;
        this.customerId = customerId;
        this.orderHolder = orderHolder;
        this.orderDetails = orderDetails;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public List<RestaurantCounterOrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<RestaurantCounterOrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
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
                "orderId=" + orderId +
                ", orderState='" + orderState + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", dataValue='" + dataValue + '\'' +
                ", customerId=" + customerId +
                ", orderHolder=" + orderHolder +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
