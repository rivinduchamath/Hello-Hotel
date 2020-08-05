package lk.sliit.hotelManagement.entity.reservation;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class GeneralBill {
    @Id
    private String billId;
    private double amount;
    private String type;
    private String firstName;
    private String lastName;
    private Date date;
    private String status;
    private String reservationId;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="customerId",referencedColumnName = "customerId")
    private Customer customer;

    public GeneralBill(String billId, double amount, String type, String firstName, String lastName, Date date, String status, String reservationId, Customer customer) {
        this.billId = billId;
        this.amount = amount;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.status = status;
        this.reservationId = reservationId;
        this.customer = customer;
    }

    public GeneralBill() {
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
