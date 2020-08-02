package lk.sliit.employeeManagement.entity.kitchen;

import lk.sliit.employeeManagement.entity.restaurant.Report;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.employeeManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodItem {
    @Id
    private String itemId;
    private String name;
    private double unitePrice;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinTable(name = "MenuItems", joinColumns = { @JoinColumn(name = "itemId") },inverseJoinColumns = { @JoinColumn(name = "menuId") })
    private List<Menu> menus = new ArrayList<>();
    @OneToMany(mappedBy = "foodItem", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<Report> reports = new ArrayList<>();
    @OneToMany(mappedBy = "foodItem", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantCounterOrderDetail> restaurantCounterOrderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "foodItem", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantOnlineOrderDetails> restaurantOnlineOrderDetails = new ArrayList<>();


    public FoodItem(String itemId, String name, double unitePrice, List<Menu> menus) {
        this.itemId = itemId;
        this.name = name;
        this.unitePrice = unitePrice;
        this.menus = menus;
    }


    public FoodItem() {
    }

    public List<Report> getReports() {
        return reports;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }
}
