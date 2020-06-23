package lk.sliit.employeeManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Inventory implements SuperEntity {
    @Id
    private String inventoryId ;
    private String text;
    private String description;
    private String orderQty;
    private String orderLimit;
    private double getPrice;
    private double sellingPrice;
    private Date date;
    private Date expDate;


    public Inventory() {
    }

    public Inventory(String inventoryId, String text, String description, String orderQty, String orderLimit, double getPrice, double sellingPrice, Date date, Date expDate) {
        this.inventoryId = inventoryId;
        this.text = text;
        this.description = description;
        this.orderQty = orderQty;
        this.orderLimit = orderLimit;
        this.getPrice = getPrice;
        this.sellingPrice = sellingPrice;
        this.date = date;
        this.expDate = expDate;
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

    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
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

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
}//End Class

