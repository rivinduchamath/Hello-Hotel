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
    private String tableId;
    @OneToMany(mappedBy = "tableId", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<OnlineTableReservationDetails> orderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "tableId", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<CounterTableReservationDetails> counterTableReservationDetails = new ArrayList<>();


    public RestaurantTable(String tableId) {
        this.tableId = tableId;
    }

    public RestaurantTable() {
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
