package lk.sliit.hotelManagement.entity.restaurant.counterTableReservation;

import lk.sliit.hotelManagement.entity.restaurant.RestaurantTable;

import javax.persistence.*;

@Entity
public class CounterTableReservationDetails {
    @EmbeddedId
    private CounterTableReservationDetailsPK counterTableReservationDetailsPK;
    private double unitePrice;
    private double quantity;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "counterTableReserveId", referencedColumnName = "counterTableReserveId", insertable = false, updatable = false)
    private CounterTableReservation counterTableReservation;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "tableId", referencedColumnName = "tableId", insertable = false, updatable = false)
    private RestaurantTable tableId;

    public CounterTableReservationDetails(CounterTableReservationDetailsPK counterTableReservationDetailsPK, double unitePrice, double quantity) {
        this.counterTableReservationDetailsPK = counterTableReservationDetailsPK;
        this.unitePrice = unitePrice;
        this.quantity = quantity;
    }


    public CounterTableReservationDetails(String counterTableReserveId,String tableId, double unitePrice, double quantity) {
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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

