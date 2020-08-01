package lk.sliit.employeeManagement.entity.restaurant.counterOrder;


import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantCounterOrder {

    @Id
    private String orderId;
    private String orderState;
    private double quantity;
    private Date date;
    private String customerId;
    @OneToMany(mappedBy = "restaurantCounterOrder", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantCounterOrderDetail> orderDetails = new ArrayList<>();


    public RestaurantCounterOrder(String orderId, String orderState, double quantity, Date date, String customerId) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.quantity = quantity;
        this.date = date;
        this.customerId = customerId;

    }

    public RestaurantCounterOrder() {
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

    public List<RestaurantCounterOrderDetail> getOrderDetails() {
        return orderDetails;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
