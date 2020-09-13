package lk.sliit.hotelManagement.entity.reservation;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReservationDetailsPK implements Serializable {

    private int reservationId;
    private int roomId;

    public ReservationDetailsPK(int reservationId, int roomId) {
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
