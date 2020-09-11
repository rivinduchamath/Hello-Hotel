package lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OnlineTableReservationDetailsPK implements Serializable {

    private int reservationId;
    private int tableId;

    public OnlineTableReservationDetailsPK(int reservationId, int tableId) {
        this.reservationId = reservationId;
        this.tableId = tableId;
    }

    public OnlineTableReservationDetailsPK() {
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}
