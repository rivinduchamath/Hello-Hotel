package lk.sliit.hotelManagement.entity.reservation;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReservationDetailsPK implements Serializable {

    private int reservationId;
    private String roomId;

    public ReservationDetailsPK(int reservationId, String roomId) {
        this.reservationId = reservationId;
        this.roomId = roomId;
    }

    public ReservationDetailsPK() {
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
