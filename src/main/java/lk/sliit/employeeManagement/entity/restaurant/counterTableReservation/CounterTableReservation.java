package lk.sliit.employeeManagement.entity.restaurant.counterTableReservation;

import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CounterTableReservation {
    @Id
    private String counterTableReserveId;
    @OneToMany(mappedBy = "counterTableReservation", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<CounterTableReservationDetails> orderDetails = new ArrayList<>();


    public CounterTableReservation(String counterTableReserveId, List<CounterTableReservationDetails> orderDetails) {
        this.counterTableReserveId = counterTableReserveId;
        this.orderDetails = orderDetails;
    }

    public CounterTableReservation() {
    }

    public String getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(String counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }

    public List<CounterTableReservationDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<CounterTableReservationDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
