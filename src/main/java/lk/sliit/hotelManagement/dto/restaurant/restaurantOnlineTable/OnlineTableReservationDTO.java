package lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


public class OnlineTableReservationDTO {

    private int onlineTableReservationId;
    @Temporal(TemporalType.DATE)
    private Date reservedDate;
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;
    private int noOfTables;
    private int customer;
    private String vStatT;
    private String vEndT;
    private String vDate;

    private String orderData;

    public OnlineTableReservationDTO(int onlineTableReservationId, Date reservedDate,
                                     Date date, Date startTime, Date endTime, int noOfTables, int customer) {
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

    public OnlineTableReservationDTO(int onlineTableReservationId) {
        this.onlineTableReservationId = onlineTableReservationId;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public int getOnlineTableReservationId() {
        return onlineTableReservationId;
    }

    public void setOnlineTableReservationId(int onlineTableReservationId) {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getNoOfTables() {
        return noOfTables;
    }

    public void setNoOfTables(int noOfTables) {
        this.noOfTables = noOfTables;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public String getvStatT() {
        return vStatT;
    }

    public void setvStatT(String vStatT) {
        this.vStatT = vStatT;
    }

    public String getvEndT() {
        return vEndT;
    }

    public void setvEndT(String vEndT) {
        this.vEndT = vEndT;
    }

    public String getvDate() {
        return vDate;
    }

    public void setvDate(String vDate) {
        this.vDate = vDate;
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
                ", stat='" + vStatT + '\'' +
                ", end='" + vEndT + '\'' +
                '}';
    }
}
