package lk.sliit.hotelManagement.entity.restaurant;

import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservation;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrder;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;

import javax.persistence.*;

@Entity
public class RestaurantBill {
    @Id
    private int billId;
    private String type;
    private double total;
    private double discount;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="restaurantOrder",referencedColumnName = "orderId", insertable = false, updatable = false,nullable = true)
    private RestaurantCounterOrder restaurantOrder;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="onlineOrder",referencedColumnName = "orderId", insertable = false, updatable = false,nullable = true)
    private RestaurantOnlineOrder onlineOrder;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="counterTableReservation",referencedColumnName = "counterTableReserveId",nullable = true, insertable = false, updatable = false)
    private CounterTableReservation counterTableReserveId;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="onlineTableReservationId",referencedColumnName = "onlineTableReservationId", insertable = false, updatable = false,nullable = true)
    private OnlineTableReservation onlineTableReservation;

    public RestaurantBill() {
    }

    public RestaurantBill(int billId, String type, double total,
                          double discount, RestaurantCounterOrder restaurantOrder,
                          RestaurantOnlineOrder onlineOrder,
                          CounterTableReservation counterTableReserveId,
                          OnlineTableReservation onlineTableReservation) {
        this.billId = billId;
        this.type = type;
        this.total = total;
        this.discount = discount;
        this.restaurantOrder = restaurantOrder;
        this.onlineOrder = onlineOrder;
        this.counterTableReserveId = counterTableReserveId;
        this.onlineTableReservation = onlineTableReservation;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
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

    public CounterTableReservation getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(CounterTableReservation counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }

    public OnlineTableReservation getOnlineTableReservation() {
        return onlineTableReservation;
    }

    public void setOnlineTableReservation(OnlineTableReservation onlineTableReservation) {
        this.onlineTableReservation = onlineTableReservation;
    }
}
