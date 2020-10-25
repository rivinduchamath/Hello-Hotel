package lk.sliit.hotelManagement.dto.reservation;

import lk.sliit.hotelManagement.entity.reservation.Customer;
import java.sql.Date;

public class ReservationDTO {


    private int reservationId;
    private String type;
    private Date date;
    private int noOfRooms;
    private int customer;
    private String details;
    private Date checkIn;
    private Date checkOut;

    public ReservationDTO(int reservationId ,int customer, String details, Date checkIn, Date checkOut) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.details = details;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public ReservationDTO(int reservationId, String type, Date date, int noOfRooms, int customer) {
        this.reservationId = reservationId;
        this.type = type;
        this.date = date;
        this.noOfRooms = noOfRooms;
        this.customer = customer;
    }

    public ReservationDTO(int reservationId, String type, Date date, int noOfRooms, int customer, String details) {
        this.reservationId = reservationId;
        this.type = type;
        this.date = date;
        this.noOfRooms = noOfRooms;
        this.customer = customer;
        this.details = details;
    }

    public ReservationDTO() {
    }

    public ReservationDTO(int reservationId) {
        this.reservationId = reservationId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "reservationId='" + reservationId + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", noOfRooms=" + noOfRooms +
                ", customer=" + customer +
                ", details='" + details + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}//End Class

