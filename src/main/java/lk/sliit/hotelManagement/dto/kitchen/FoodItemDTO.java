package lk.sliit.hotelManagement.dto.kitchen;

import lk.sliit.hotelManagement.entity.kitchen.Menu;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


public class FoodItemDTO {
    private int itemId;
    private String itemName;
    private double unitePrice;
    private String itemCategory;
    private String src;
    private String getId;


    public FoodItemDTO(int itemId, String itemName, double unitePrice, String itemCategory, String src) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitePrice = unitePrice;
        this.itemCategory = itemCategory;
        this.src = src;
    }

    public FoodItemDTO() {
    }

    public String getGetId() {
        return getId;
    }

    public void setGetId(String getId) {
        this.getId = getId;
    }

    public FoodItemDTO(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "FoodItemDTO{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unitePrice=" + unitePrice +
                ", itemCategory='" + itemCategory + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
