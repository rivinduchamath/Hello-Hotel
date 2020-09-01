package lk.sliit.hotelManagement.entity.houseKeeping;

import lk.sliit.hotelManagement.entity.reservation.Customer;

import javax.persistence.*;

@Entity
public class LaundryBill {

    @Id
    private String laundryBillId;
    private double pieces;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    public LaundryBill(String laundryBillId, double pieces, Customer customer) {
        this.laundryBillId = laundryBillId;
        this.pieces = pieces;
        this.customer = customer;
    }

    public LaundryBill() {
    }

    public String getLaundryBillId() {
        return laundryBillId;
    }

    public void setLaundryBillId(String laundryBillId) {
        this.laundryBillId = laundryBillId;
    }

    public double getPieces() {
        return pieces;
    }

    public void setPieces(double pieces) {
        this.pieces = pieces;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
