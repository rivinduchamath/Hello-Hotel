package lk.sliit.employeeManagement.entity.restaurant.onlineCounterOrder;

import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantOnlineOrder {
    @Id
    private String orderId;
    @OneToMany(mappedBy = "restaurantOnlineOrder", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantOnlineOrderDetails> orderDetails = new ArrayList<>();

    public RestaurantOnlineOrder(String orderId, List<RestaurantOnlineOrderDetails> orderDetails) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    public RestaurantOnlineOrder() {
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


}
