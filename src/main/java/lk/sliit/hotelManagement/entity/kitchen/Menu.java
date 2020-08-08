package lk.sliit.hotelManagement.entity.kitchen;

import lk.sliit.hotelManagement.entity.banquet.BanquetOrder;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    private String menuId;
    private String name;
    private String type;
    private String picture;
    private String src;
    private double unitPrice;
    @OneToMany(mappedBy = "menu", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<BanquetOrder> banquetOrders = new ArrayList<>();
    @ManyToMany(mappedBy = "menus")
    private List<FoodItem> foodItems = new ArrayList<>();

    public Menu() {
    }

    public Menu(String menuId, String name, String type, String picture, String src, double unitPrice) {
        this.menuId = menuId;
        this.name = name;
        this.type = type;
        this.picture = picture;
        this.src = src;
        this.unitPrice = unitPrice;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<BanquetOrder> getBanquetOrders() {
        return banquetOrders;
    }

    public void setBanquetOrders(List<BanquetOrder> banquetOrders) {
        this.banquetOrders = banquetOrders;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
