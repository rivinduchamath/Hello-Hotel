package lk.sliit.employeeManagement.dto.reservation;

import lk.sliit.employeeManagement.entity.reservation.Customer;
import java.sql.Date;

public class ReservationDTO {


    private String reservationId;
    private String type;
    private Date date;
    private int noOfRooms;
    private Customer customer;

    public ReservationDTO(String reservationId, String type, Date date, int noOfRooms, Customer customer) {
        this.reservationId = reservationId;
        this.type = type;
        this.date = date;
        this.noOfRooms = noOfRooms;
        this.customer = customer;
    }

    public ReservationDTO() {
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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
                '}';
    }
}//End Class

