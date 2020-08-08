package lk.sliit.hotelManagement.entity.kitchen;

import lk.sliit.hotelManagement.entity.restaurant.Report;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodItem {
    @Id
    private String itemId;
    private String name;
    private double unitePrice;
    private String src;
    private String category;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinTable(name = "MenuItems", joinColumns = { @JoinColumn(name = "itemId") },inverseJoinColumns = { @JoinColumn(name = "menuId") })
    private List<Menu> menus = new ArrayList<>();
    @OneToMany(mappedBy = "foodItem", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<Report> reports = new ArrayList<>();
    @OneToMany(mappedBy = "foodItem", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantCounterOrderDetail> restaurantCounterOrderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "foodItem", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantOnlineOrderDetails> restaurantOnlineOrderDetails = new ArrayList<>();


    public FoodItem(String itemId, String name, double unitePrice, String src, String category, List<Menu> menus) {
        this.itemId = itemId;
        this.name = name;
        this.unitePrice = unitePrice;
        this.src = src;
        this.category = category;
        this.menus = menus;

    }

    public FoodItem() {
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
