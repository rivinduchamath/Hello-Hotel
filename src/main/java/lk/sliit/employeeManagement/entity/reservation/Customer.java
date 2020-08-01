package lk.sliit.employeeManagement.entity.reservation;

import lk.sliit.employeeManagement.entity.banquet.BanquetOrder;
import javax.persistence.*;

@Entity
public class Customer {
    @Id
    private String customerId;
    private String email;
    private String name;
    private String address;
    private int contactNumber;


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
