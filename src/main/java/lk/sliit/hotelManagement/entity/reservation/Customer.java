package lk.sliit.hotelManagement.entity.reservation;

import lk.sliit.hotelManagement.entity.banquet.BanquetOrder;
import lk.sliit.hotelManagement.entity.houseKeeping.LaundryBill;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String customerId;
    private String email;
    private String name;
    private String address;
    private int contactNumber;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<Reservation> reservations = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<GeneralBill> generalBills = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<LaundryBill> laundryBills = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<BanquetOrder> banquetOrders = new ArrayList<>();




    public Customer(String customerId, String email, String name, String address, int contactNumber) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Customer() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }


}