package lk.sliit.hotelManagement.entity.restaurant.onlineOrder;

import lk.sliit.hotelManagement.entity.restaurant.OnlineCustomer;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantOnlineOrder {
    @Id
    private int orderId;
    private String orderState;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "onlineCustomerId", referencedColumnName = "onlineCustomerId", nullable = false)
    private OnlineCustomer customer;
    @OneToMany(mappedBy = "restaurantOnlineOrder", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantOnlineOrderDetails> orderDetails = new ArrayList<>();

    public RestaurantOnlineOrder(int orderId, String orderState, Date date, OnlineCustomer customer) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.date = date;
        this.customer = customer;
    }

    public RestaurantOnlineOrder() {
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

    public OnlineCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(OnlineCustomer customer) {
        this.customer = customer;
    }

    public List<RestaurantOnlineOrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<RestaurantOnlineOrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


}
