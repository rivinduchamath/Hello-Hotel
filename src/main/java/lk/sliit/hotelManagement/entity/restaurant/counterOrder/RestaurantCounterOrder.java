package lk.sliit.hotelManagement.entity.restaurant.counterOrder;


import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantCounterOrder {

    @Id
    private int orderId;
    private String orderState;
    private double quantity;
    private Date date;
    private String customerId;
    private String orderHolder;
    @OneToMany(mappedBy = "restaurantCounterOrder", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantCounterOrderDetail> orderDetails = new ArrayList<>();


    public RestaurantCounterOrder(int orderId, String orderState, double quantity, Date date, String customerId, String orderHolder) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.quantity = quantity;
        this.date = date;
        this.customerId = customerId;
        this.orderHolder = orderHolder;
    }

    public RestaurantCounterOrder() {
    }

    public String getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(String orderHolder) {
        this.orderHolder = orderHolder;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
