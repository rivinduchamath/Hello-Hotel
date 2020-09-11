package lk.sliit.hotelManagement.entity.reservation;

import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class ReservationDetails {

    @EmbeddedId
    private ReservationDetailsPK reservationDetailsPK;
    private Date arrivalDate;
    private Date departureDate;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="reservationId",referencedColumnName = "reservationId", insertable = false, updatable = false)
    private Reservation reservationId;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="roomId",referencedColumnName = "roomId", insertable = false, updatable = false)
    private HotelRoom roomId;

    public ReservationDetails() {
    }

    public ReservationDetails(ReservationDetailsPK reservationDetailsPK, Date arrivalDate, Date departureDate) {
        this.reservationDetailsPK = reservationDetailsPK;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }
    public ReservationDetails(int reservationId, int roomId, Date arrivalDate, Date departureDate) {
        this.reservationDetailsPK = new ReservationDetailsPK(reservationId,roomId);
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public ReservationDetailsPK getReservationDetailsPK() {
        return reservationDetailsPK;
    }

    public HotelRoom getRoomId() {
        return roomId;
    }

    public void setRoomId(HotelRoom roomId) {
        this.roomId = roomId;
    }

    public void setReservationDetailsPK(ReservationDetailsPK reservationDetailsPK) {
        this.reservationDetailsPK = reservationDetailsPK;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Reservation getReservationId() {
        return reservationId;
    }

    public void setReservationId(Reservation reservationId) {
        this.reservationId = reservationId;
    }
}
