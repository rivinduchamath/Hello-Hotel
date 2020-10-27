package lk.sliit.hotelManagement.dto.reservation;

import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;


import java.sql.Date;

public class ReservationDetailDTO {
    private int roomId;
    private Date arrivalDate;
    private Date departureDate;

    public ReservationDetailDTO(int roomId, Date arrivalDate, Date departureDate) {
        this.roomId = roomId;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public ReservationDetailDTO() {
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    @Override
    public String toString() {
        return "ReservationDetailDTO{" +
                "roomId=" + roomId +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                '}';
    }
}
