package lk.sliit.employeeManagement.entity.kitchen;

import lk.sliit.employeeManagement.entity.restaurant.Report;
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


    public FoodItem(String itemId, String name, double unitePrice) {
        this.itemId = itemId;
        this.name = name;
        this.unitePrice = unitePrice;
    }

    public FoodItem() {
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
