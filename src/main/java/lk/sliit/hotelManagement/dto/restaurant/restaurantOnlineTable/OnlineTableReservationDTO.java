package lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


public class OnlineTableReservationDTO {

    private String onlineTableReservationId;
    private java.sql.Date reservedDate;
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;
    private int noOfTables;
    private String customer;
    private String stat;
    private String end;

    public OnlineTableReservationDTO(String onlineTableReservationId, java.sql.Date reservedDate,
                                     Date date, java.util.Date startTime, java.util.Date endTime, int noOfTables, String customer) {
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

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getOnlineTableReservationId() {
        return onlineTableReservationId;
    }

    public void setOnlineTableReservationId(String onlineTableReservationId) {
        this.onlineTableReservationId = onlineTableReservationId;
    }

    public java.sql.Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(java.sql.Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public java.util.Date getStartTime() {
        return startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.util.Date getEndTime() {
        return endTime;
    }

    public void setEndTime(java.util.Date endTime) {
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
                ", stat='" + stat + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
