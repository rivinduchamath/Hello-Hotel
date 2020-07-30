package lk.sliit.employeeManagement.entity.restaurant;

import lk.sliit.employeeManagement.entity.restaurant.onlineCounterOrder.RestaurantOnlineOrder;

import javax.persistence.*;

@Entity
public class OnlineCustomer {
@Id
    private String onlineCustomerId;
    private  String name;
    private  String address;
    private String email;
    private String password;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="onlineOrder",referencedColumnName = "orderId", insertable = false, updatable = false)
    private RestaurantOnlineOrder onlineOrder;

    public OnlineCustomer(String onlineCustomerId, String name, String address, String email, String password) {
        this.onlineCustomerId = onlineCustomerId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public OnlineCustomer() {
    }

    public String getOnlineCustomerId() {
        return onlineCustomerId;
    }

    public void setOnlineCustomerId(String onlineCustomerId) {
        this.onlineCustomerId = onlineCustomerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RestaurantOnlineOrder getOnlineOrder() {
        return onlineOrder;
    }

    public void setOnlineOrder(RestaurantOnlineOrder onlineOrder) {
        this.onlineOrder = onlineOrder;
    }
}
