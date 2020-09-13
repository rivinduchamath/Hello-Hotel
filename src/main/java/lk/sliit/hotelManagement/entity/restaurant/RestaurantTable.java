package lk.sliit.hotelManagement.entity.restaurant;

import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservationDetails;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservationDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity

public class RestaurantTable {
    @Id
    private int tableId;
    private String type;
    private double unitPrice;
    @OneToMany(mappedBy = "tableId", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<OnlineTableReservationDetails> orderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "tableId", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<CounterTableReservationDetails> counterTableReservationDetails = new ArrayList<>();


    public RestaurantTable(int tableId, String type, double unitPrice) {
        this.tableId = tableId;
        this.type = type;
        this.unitPrice = unitPrice;
    }

    public RestaurantTable(int tableId) {
        this.tableId = tableId;
    }

    public RestaurantTable() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}
