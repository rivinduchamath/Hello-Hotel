package lk.sliit.hotelManagement.entity.restaurant.counterTableReservation;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CounterTableReservationDetailsPK implements Serializable {
    private int tableId;
    private  int counterTableReserveId;

    public CounterTableReservationDetailsPK(int tableId, int counterTableReserveId) {
        this.tableId = tableId;
        this.counterTableReserveId = counterTableReserveId;
    }

    public CounterTableReservationDetailsPK() {
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(int counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }
}

