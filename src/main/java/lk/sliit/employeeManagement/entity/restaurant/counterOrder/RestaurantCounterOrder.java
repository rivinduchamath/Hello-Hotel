package lk.sliit.employeeManagement.entity.restaurant.counterOrder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantCounterOrder {

    @Id
    private String orderId;
    @OneToMany(mappedBy = "restaurantCounterOrder", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantCounterOrderDetail> orderDetails = new ArrayList<>();

    public RestaurantCounterOrder(String orderId, List<RestaurantCounterOrderDetail> orderDetails) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    public RestaurantCounterOrder() {
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
