package lk.sliit.employeeManagement.entity.reservation;

import lk.sliit.employeeManagement.entity.banquet.BanquetOrder;
import javax.persistence.*;

@Entity
public class Customer {
    @Id
    private String customerId;
    private String name;
    private String address;
    private int contactNumber;


    public Customer(String customerId, String name, String address, int contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Customer() {
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
