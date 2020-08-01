package lk.sliit.employeeManagement.entity.restaurant.counterTableReservation;

import lk.sliit.employeeManagement.entity.kitchen.FoodItem;
import lk.sliit.employeeManagement.entity.restaurant.RestaurantTable;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetailPK;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CounterTableReservationDetails {
    @EmbeddedId
    private CounterTableReservationDetailsPK counterTableReservationDetailsPK;
    private double unitePrice;
    private String quantity;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "counterTableReserveId", referencedColumnName = "counterTableReserveId", insertable = false, updatable = false)
    private CounterTableReservation counterTableReservation;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "tableId", referencedColumnName = "tableId", insertable = false, updatable = false)
    private RestaurantTable tableId;

    public CounterTableReservationDetails(CounterTableReservationDetailsPK counterTableReservationDetailsPK, double unitePrice, String quantity) {
        this.counterTableReservationDetailsPK = counterTableReservationDetailsPK;
        this.unitePrice = unitePrice;
        this.quantity = quantity;
    }


    public CounterTableReservationDetails(String counterTableReserveId,String tableId, double unitePrice, String quantity) {
        this.counterTableReservationDetailsPK = new CounterTableReservationDetailsPK(counterTableReserveId,tableId);
        this.unitePrice = unitePrice;
        this.quantity = quantity;
    }
    public CounterTableReservationDetails() {
    }

    public CounterTableReservationDetailsPK getCounterTableReservationDetailsPK() {
        return counterTableReservationDetailsPK;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setCounterTableReservationDetailsPK(CounterTableReservationDetailsPK counterTableReservationDetailsPK) {
        this.counterTableReservationDetailsPK = counterTableReservationDetailsPK;
    }

    public CounterTableReservation getCounterTableReservation() {
        return counterTableReservation;
    }

    public void setCounterTableReservation(CounterTableReservation counterTableReservation) {
        this.counterTableReservation = counterTableReservation;
    }

    public RestaurantTable getTableId() {
        return tableId;
    }

    public void setTableId(RestaurantTable tableId) {
        this.tableId = tableId;
    }
}

