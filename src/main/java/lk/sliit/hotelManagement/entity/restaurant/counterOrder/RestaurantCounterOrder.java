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
    private int orderHolder;
    @OneToMany(mappedBy = "restaurantCounterOrder", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantCounterOrderDetail> orderDetails = new ArrayList<>();


    public RestaurantCounterOrder(int orderId, String orderState,
                                  double quantity, Date date, int orderHolder) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.quantity = quantity;
        this.date = date;
        this.orderHolder = orderHolder;
    }

    public RestaurantCounterOrder(int orderId, String orderState, double quantity,
                                  Date date, int orderHolder, List<RestaurantCounterOrderDetail> orderDetails) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.quantity = quantity;
        this.date = date;
        this.orderHolder = orderHolder;
        this.orderDetails = orderDetails;
    }

    public RestaurantCounterOrder() {
    }

    public int getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(int orderHolder) {
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

    public List<RestaurantCounterOrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<RestaurantCounterOrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
