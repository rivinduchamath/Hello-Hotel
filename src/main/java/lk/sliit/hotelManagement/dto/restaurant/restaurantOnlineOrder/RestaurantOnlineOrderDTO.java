package lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder;

import java.sql.Date;

public class RestaurantOnlineOrderDTO {

    private String orderId;
    private String orderState;
    private Date date;
    private String customer;

    public RestaurantOnlineOrderDTO(String orderId, String orderState, Date date, String customer) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.date = date;
        this.customer = customer;
    }

    public RestaurantOnlineOrderDTO() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "RestaurantOnlineOrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderState='" + orderState + '\'' +
                ", date=" + date +
                ", customer='" + customer + '\'' +
                '}';
    }
}
