package lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation;






import lk.sliit.hotelManagement.entity.restaurant.RestaurantTable;

import javax.persistence.*;

@Entity
public class OnlineTableReservationDetails {
    @EmbeddedId
    private OnlineTableReservationDetailsPK onlineTableReservationDetailsPK;
    private double quantity;
    private double unitePrice;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "reservationId", referencedColumnName = "onlineTableReservationId", insertable = false, updatable = false)
    private OnlineTableReservation onlineTableReservation;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "tableId", referencedColumnName = "tableId", insertable = false, updatable = false)
    private RestaurantTable tableId;


    public OnlineTableReservationDetails(OnlineTableReservationDetailsPK onlineTableReservationDetailsPK, double quantity, double unitePrice) {
        this.onlineTableReservationDetailsPK = onlineTableReservationDetailsPK;
        this.quantity = quantity;
        this.unitePrice = unitePrice;
    }

    public OnlineTableReservationDetails(int tableId, int onlineTableId, double quantity, double unitePrice) {
        this.onlineTableReservationDetailsPK = new OnlineTableReservationDetailsPK(onlineTableId, tableId);
        this.quantity = quantity;
        this.unitePrice = unitePrice;
    }

    public OnlineTableReservationDetails() {
    }

    public OnlineTableReservationDetailsPK getOnlineTableReservationDetailsPK() {
        return onlineTableReservationDetailsPK;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public void setOnlineTableReservationDetailsPK(OnlineTableReservationDetailsPK onlineTableReservationDetailsPK) {
        this.onlineTableReservationDetailsPK = onlineTableReservationDetailsPK;
    }

    public OnlineTableReservation getOnlineTableReservation() {
        return onlineTableReservation;
    }

    public void setOnlineTableReservation(OnlineTableReservation onlineTableReservation) {
        this.onlineTableReservation = onlineTableReservation;
    }

    public RestaurantTable getTableId() {
        return tableId;
    }

    public void setTableId(RestaurantTable tableId) {
        this.tableId = tableId;
    }
}

