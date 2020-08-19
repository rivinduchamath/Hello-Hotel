package lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OnlineTableReservationDetailsPK implements Serializable {

    private String reservationId;
    private  String tableId;

    public OnlineTableReservationDetailsPK(String reservationId, String tableId) {
        this.reservationId = reservationId;
        this.tableId = tableId;
    }

    public OnlineTableReservationDetailsPK() {
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
