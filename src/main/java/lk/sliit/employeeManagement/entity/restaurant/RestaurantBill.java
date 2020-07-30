package lk.sliit.employeeManagement.entity.restaurant;

import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.employeeManagement.entity.restaurant.onlineCounterOrder.RestaurantOnlineOrder;

import javax.persistence.*;

@Entity
public class RestaurantBill {
    @Id
    private String billId;
    private String type;
    private double total;
    private double discount;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="restaurantOrder",referencedColumnName = "orderId", insertable = false, updatable = false)
    private RestaurantCounterOrder restaurantOrder;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="onlineOrder",referencedColumnName = "orderId", insertable = false, updatable = false)
    private RestaurantOnlineOrder onlineOrder;

    public RestaurantBill() {
    }

    public RestaurantBill(String billId, String type, double total,
                          double discount) {
        this.billId = billId;
        this.type = type;
        this.total = total;
        this.discount = discount;

    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public RestaurantCounterOrder getRestaurantOrder() {
        return restaurantOrder;
    }

    public void setRestaurantOrder(RestaurantCounterOrder restaurantOrder) {
        this.restaurantOrder = restaurantOrder;
    }

    public RestaurantOnlineOrder getOnlineOrder() {
        return onlineOrder;
    }

    public void setOnlineOrder(RestaurantOnlineOrder onlineOrder) {
        this.onlineOrder = onlineOrder;
    }
}
