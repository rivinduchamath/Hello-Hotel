package lk.sliit.hotelManagement.dto.houseKeeping;

import lk.sliit.hotelManagement.dto.reservation.ReservationDetailDTO;
import lk.sliit.hotelManagement.entity.reservation.ReservationDetails;

import java.util.Collection;
import java.sql.Date;
import java.util.List;

public class GetDateHouseKeepingDTO {
    private Date dateIn;
    private Date dateOut;

//    //////////////////////////////
    private int roomId;
    private String roomName;
    private String name;
    private double price;
    private int reservationId;
    Collection<ReservationDetailDTO> reservationDetails;


    public GetDateHouseKeepingDTO(Date dateIn, Date dateOut) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public GetDateHouseKeepingDTO(Date dateIn, Date dateOut, int roomId, String roomName, double price) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.roomId = roomId;
        this.roomName = roomName;
        this.price = price;
    }

    public GetDateHouseKeepingDTO() {
    }

    public GetDateHouseKeepingDTO(Date dateIn, Date dateOut, String name, int reservationId, Collection<ReservationDetailDTO> reservationDetails) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.name = name;
        this.reservationId = reservationId;
        this.reservationDetails = reservationDetails;
    }


    public Date getDateIn() {
        return dateIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Collection<ReservationDetailDTO> getReservationDetails() {
        return reservationDetails;
    }

    public void setReservationDetails(Collection<ReservationDetailDTO> reservationDetails) {
        this.reservationDetails = reservationDetails;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GetDateHouseKeepingDTO{" +
                "dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                ", roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", reservationId=" + reservationId +
                ", reservationDetails=" + reservationDetails +
                '}';
    }
}
