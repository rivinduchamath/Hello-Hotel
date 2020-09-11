package lk.sliit.hotelManagement.dto.inventory;


import lk.sliit.hotelManagement.entity.inventory.Inventory;

import java.sql.Date;

public class InventoryNoticeDTO {

    private int noticeId ;
    private String department;
    private double orderQty;
    private Date date;
    private Date expDate;
    private String orderHolder;
    private boolean state;
    private int inventoryId;
    private String text;
    private double qtyOnHand;
    private double updatedQty;
    private double requiredQty;


    public InventoryNoticeDTO() {
    }



    public InventoryNoticeDTO(int noticeId, String department,
                              double orderQty, Date date, Date expDate, String orderHolder,
                              boolean state, int inventoryid) {
        this.noticeId = noticeId;
        this.department = department;
        this.orderQty = orderQty;
        this.date = date;
        this.expDate = expDate;
        this.orderHolder = orderHolder;
        this.state = state;
        this.inventoryId = inventoryid;
    }

    public InventoryNoticeDTO(int noticeId, String department,
                              double orderQty, Date date, Date expDate,
                              String orderHolder, boolean state,
                              int inventoryId, String text, double qtyOnHand) {
        this.noticeId = noticeId;
        this.department = department;
        this.orderQty = orderQty;
        this.date = date;
        this.expDate = expDate;
        this.orderHolder = orderHolder;
        this.state = state;
        this.inventoryId = inventoryId;
        this.text = text;
        this.qtyOnHand = qtyOnHand;
    }

    public InventoryNoticeDTO(int noticeId) { this.noticeId = noticeId;
    }


    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public double getUpdatedQty() {
        return updatedQty;
    }

    public void setUpdatedQty(double updatedQty) {
        this.updatedQty = updatedQty;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(double orderQty) {
        this.orderQty = orderQty;
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

    public String getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(String orderHolder) {
        this.orderHolder = orderHolder;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getInventory() {
        return inventoryId;
    }

    public void setInventory(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public double getRequiredQty() {
        return requiredQty;
    }

    public void setRequiredQty(double requiredQty) {
        this.requiredQty = requiredQty;
    }
}//End Class

