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
    private double unitPrice;
    @OneToMany(mappedBy = "menu", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<BanquetOrder> banquetOrders = new ArrayList<>();
    @OneToMany(mappedBy = "menu", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<MenuDetails> orderDetails = new ArrayList<>();

    public Menu(String menuId, String name, String type, String picture, double unitPrice) {
        this.menuId = menuId;
        this.name = name;
        this.type = type;
        this.picture = picture;
        this.unitPrice = unitPrice;

    }

    public Menu() {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
