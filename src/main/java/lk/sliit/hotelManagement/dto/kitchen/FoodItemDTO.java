package lk.sliit.hotelManagement.dto.kitchen;

import lk.sliit.hotelManagement.entity.kitchen.Menu;

import java.util.ArrayList;
import java.util.List;


public class FoodItemDTO {
    private String itemId;
    private String name;
    private double unitePrice;
      private List<Menu> menus = new ArrayList<>();

    public FoodItemDTO(String itemId, String name, double unitePrice, List<Menu> menus) {
        this.itemId = itemId;
        this.name = name;
        this.unitePrice = unitePrice;
        this.menus = menus;
    }

    public FoodItemDTO() {
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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "FoodItemDTO{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", unitePrice=" + unitePrice +
                ", menus=" + menus +
                '}';
    }
}
