package lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable;

import java.sql.Date;
import java.sql.Time;

public class OnlineTableReservationDTO {

    private String onlineTableReservationId;
    private Date reservedDate;
    private Date date;
    private Time startTime;
    private Time endTime;
    private int noOfTables;
    private String customer;

    public OnlineTableReservationDTO(String onlineTableReservationId, Date reservedDate, Date date, Time startTime, Time endTime, int noOfTables, String customer) {
        this.onlineTableReservationId = onlineTableReservationId;
        this.reservedDate = reservedDate;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfTables = noOfTables;
        this.customer = customer;
    }

    public OnlineTableReservationDTO() {
    }

    public String getOnlineTableReservationId() {
        return onlineTableReservationId;
    }

    public void setOnlineTableReservationId(String onlineTableReservationId) {
        this.onlineTableReservationId = onlineTableReservationId;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getNoOfTables() {
        return noOfTables;
    }

    public void setNoOfTables(int noOfTables) {
        this.noOfTables = noOfTables;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "OnlineTableReservationDTO{" +
                "onlineTableReservationId='" + onlineTableReservationId + '\'' +
                ", reservedDate=" + reservedDate +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", noOfTables=" + noOfTables +
                ", customer='" + customer + '\'' +
                '}';
    }
}
