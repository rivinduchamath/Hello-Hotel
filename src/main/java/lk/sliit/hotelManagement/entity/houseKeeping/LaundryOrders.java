package lk.sliit.hotelManagement.entity.houseKeeping;


import lk.sliit.hotelManagement.entity.reservation.Customer;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class LaundryOrders {

    @Id
    private int laundryId;
    private int orderHolder;
    private double  pieces;
    private Date expectedDate;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customerId;

    public LaundryOrders(int laundryId,  int orderHolder, double pieces, Date expectedDate, Date date,Customer customerId) {
        this.laundryId = laundryId;
        this.customerId = customerId;
        this.orderHolder = orderHolder;
        this.pieces = pieces;
        this.expectedDate = expectedDate;
        this.date = date;
    }

    public LaundryOrders() {
    }

    public int getLaundryId() {
        return laundryId;
    }

    public void setLaundryId(int laundryId) {
        this.laundryId = laundryId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public int getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(int orderHolder) {
        this.orderHolder = orderHolder;
    }

    public double getPieces() {
        return pieces;
    }

    public void setPieces(double pieces) {
        this.pieces = pieces;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
