package lk.sliit.hotelManagement.entity.reservation;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReservationDetailsPK implements Serializable {

   private String reservationId;
        private String roomId;

    public ReservationDetailsPK(String reservationId, String roomId) {
        this.reservationId = reservationId;
        this.roomId = roomId;
    }

    public ReservationDetailsPK() {
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
