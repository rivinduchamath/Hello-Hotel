package lk.sliit.hotelManagement.entity.restaurant.counterTableReservation;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CounterTableReservationDetailsPK implements Serializable {
    private String tableId;
    private  String counterTableReserveId;

    public CounterTableReservationDetailsPK(String tableId, String counterTableReserveId) {
        this.tableId = tableId;
        this.counterTableReserveId = counterTableReserveId;
    }

    public CounterTableReservationDetailsPK() {
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(String counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }
}

