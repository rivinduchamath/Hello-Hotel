package lk.sliit.employeeManagement.entity.restaurant;

import lk.sliit.employeeManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrder;
import lk.sliit.employeeManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OnlineCustomer {
@Id
    private String onlineCustomerId;
    private  String name;
    private  String userName;
    private  String address;
    private String email;
    private String password;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantOnlineOrder> restaurantOnlineOrders = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<OnlineTableReservation> onlineTableReservations = new ArrayList<>();


    public OnlineCustomer(String onlineCustomerId, String name, String userName, String address, String email, String password) {
        this.onlineCustomerId = onlineCustomerId;
        this.name = name;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
