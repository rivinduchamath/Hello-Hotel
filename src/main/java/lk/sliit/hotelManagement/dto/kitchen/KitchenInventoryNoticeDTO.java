package lk.sliit.hotelManagement.dto.kitchen;

import lk.sliit.hotelManagement.entity.inventory.Inventory;

import java.sql.Date;

public class KitchenInventoryNoticeDTO {

    private int noticeId ;
    private String department;
    private double orderQty;
    private Date date;
    private Date expDate;
    private int orderHolder;
    private boolean state;
    private Inventory inventory;

    public KitchenInventoryNoticeDTO() {
    }

    public KitchenInventoryNoticeDTO(int noticeId, String department, double orderQty, Date date, Date expDate, int orderHolder, boolean state, Inventory inventory) {
        this.noticeId = noticeId;
        this.department = department;
        this.orderQty = orderQty;
        this.date = date;
        this.expDate = expDate;
        this.orderHolder = orderHolder;
        this.state = state;
        this.inventory = inventory;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public String getDepartment() {
        return department;
    }

    public double getOrderQty() {
        return orderQty;
    }

    public Date getDate() {
        return date;
    }

    public Date getExpDate() {
        return expDate;
    }

    public int getOrderHolder() {
        return orderHolder;
    }

    public boolean isState() {
        return state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOrderQty(double orderQty) {
        this.orderQty = orderQty;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public void setOrderHolder(int orderHolder) {
        this.orderHolder = orderHolder;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
