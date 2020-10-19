package lk.sliit.hotelManagement.dto.kitchen;

import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.kitchen.Menu;
import lk.sliit.hotelManagement.entity.kitchen.MenuDetailsPK;

public class MenuDTO {
    private int menuId;
    private int itemId;
    private String name;
    private String type;
    private String picture;
    private double unitPrice;

    public MenuDTO(int menuId, String name, String type, String picture, double unitPrice) {
        this.menuId = menuId;
        this.name = name;
        this.type = type;
        this.picture = picture;
        this.unitPrice = unitPrice;
    }

    public MenuDTO(int menuId) {
        this.menuId = menuId;
    }

    public MenuDTO() {
    }

    public MenuDTO(int foodItem, int itemId) {
        this.menuId = foodItem;
        this.itemId = itemId;
    }



    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
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

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuId='" + menuId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", picture='" + picture + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
