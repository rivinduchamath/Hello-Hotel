package lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable;

import java.sql.Date;


public class OnlineTableReservationDTO {

    private String onlineTableReservationId;
    private Date reservedDate;
    private Date date;
    private String startTime;
    private String endTime;
    private int noOfTables;
    private String customer;

    public OnlineTableReservationDTO(String onlineTableReservationId, Date reservedDate, Date date, String startTime, String endTime, int noOfTables, String customer) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
