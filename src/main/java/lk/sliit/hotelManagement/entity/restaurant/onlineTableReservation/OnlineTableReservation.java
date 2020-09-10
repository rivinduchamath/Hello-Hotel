package lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation;

import lk.sliit.hotelManagement.entity.restaurant.OnlineCustomer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OnlineTableReservation {

    @Id
    private String onlineTableReservationId;
    private Date reservedDate;
    private Date date;
    @DateTimeFormat(pattern="hh:mm:ss" )
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @DateTimeFormat(pattern="hh:mm:ss" )
    @Temporal(TemporalType.TIME)
    private Date endTime;
    private int noOfTables;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "onlineCustomerId", referencedColumnName = "onlineCustomerId", nullable = false)
    private OnlineCustomer customer;
    @OneToMany(mappedBy = "onlineTableReservation", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<OnlineTableReservationDetails> orderDetails = new ArrayList<>();

    public OnlineTableReservation(String onlineTableId, Date reservedDate, Date date,  Date startTime, Date endTime, int noOfTables, OnlineCustomer customer) {
        this.onlineTableReservationId = onlineTableId;
        this.reservedDate = reservedDate;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfTables = noOfTables;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public OnlineTableReservation() {
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

    public OnlineCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(OnlineCustomer customer) {
        this.customer = customer;
    }

    public List<OnlineTableReservationDetails> getOrderDetails() {
        return orderDetails;
    }

 }
