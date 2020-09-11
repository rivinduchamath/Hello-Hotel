package lk.sliit.hotelManagement.dto.inventory;

import java.sql.Date;

public class InventoryDTO {

    private String inventoryId ;
    private String text;
    private String description;
    private double orderQty;
    private  String type;
    private String orderLimit;
    private double getPrice;
    private double sellingPrice;
    private Date date;
//    ////////////////////////////////////
    private String supplierId;
    private String orderId;
    private String orderHolder;



    public InventoryDTO() {
    }

    public InventoryDTO(String inventoryId, String text, String description,
                        double orderQty, String type, String orderLimit,
                        double getPrice, double sellingPrice, Date date) {
        this.inventoryId = inventoryId;
        this.text = text;
        this.description = description;
        this.orderQty = orderQty;
        this.type = type;
        this.orderLimit = orderLimit;
        this.getPrice = getPrice;
        this.sellingPrice = sellingPrice;
        this.date = date;

    }

    public InventoryDTO(String orderId) {
        this.orderId =orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(String orderHolder) {
        this.orderHolder = orderHolder;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(double orderQty) {
        this.orderQty = orderQty;
    }

    public String getOrderLimit() {
        return orderLimit;
    }

    public void setOrderLimit(String orderLimit) {
        this.orderLimit = orderLimit;
    }

    public double getGetPrice() {
        return getPrice;
    }

    public void setGetPrice(double getPrice) {
        this.getPrice = getPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}//End Class

