package lk.sliit.hotelManagement.dto.kitchen;

import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;

import java.sql.Date;

public class KitchenFoodOrderDTO {

    private int orderId;
    private int foodItemId;
    private String description;
    private double amount;
    private Date expectedDate;

    String itemName;
    boolean state;
    int menuId;
    int banquetId;
    String stateStr;

    public KitchenFoodOrderDTO() {
    }

    public KitchenFoodOrderDTO(int orderId, int foodItemId, String description, double amount, Date expectedDate) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
        this.description = description;
        this.amount = amount;
        this.expectedDate = expectedDate;
    }

    public KitchenFoodOrderDTO(int orderId, int foodItemId, String description, double amount, Date expectedDate,
                               String itemName, boolean state, int menuId, int banquetId) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
        this.description = description;
        this.amount = amount;
        this.expectedDate = expectedDate;
        this.itemName = itemName;
        this.state = state;
        this.menuId = menuId;
        this.banquetId = banquetId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getBanquetId() {
        return banquetId;
    }

    public void setBanquetId(int banquetId) {
        this.banquetId = banquetId;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }
}
