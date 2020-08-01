package lk.sliit.employeeManagement.entity.restaurant.onlineTableReservation;

import lk.sliit.employeeManagement.entity.restaurant.OnlineCustomer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OnlineTableReservation {

    @Id
    private String onlineTableId;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "onlineCustomerId", referencedColumnName = "onlineCustomerId", nullable = false)
    private OnlineCustomer customer;
    @OneToMany(mappedBy = "onlineTableReservation", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<OnlineTableReservationDetails> orderDetails = new ArrayList<>();

    public OnlineTableReservation(String onlineTableId, List<OnlineTableReservationDetails> orderDetails) {
        this.onlineTableId = onlineTableId;
        this.orderDetails = orderDetails;
    }

    public OnlineTableReservation() {
    }

    public String getOnlineTableId() {
        return onlineTableId;
    }

    public void setOnlineTableId(String onlineTableId) {
        this.onlineTableId = onlineTableId;
    }

    public List<OnlineTableReservationDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OnlineTableReservationDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
