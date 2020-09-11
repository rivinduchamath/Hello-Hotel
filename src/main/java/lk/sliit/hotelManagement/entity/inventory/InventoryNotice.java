package lk.sliit.hotelManagement.entity.inventory;

import lk.sliit.hotelManagement.entity.SuperEntity;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class InventoryNotice implements SuperEntity {
    @Id
    private int noticeId ;
    private String department;
    private double orderQty;
    private Date date;
    private Date expDate;
    private String orderHolder;
    private boolean state;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "inventory", referencedColumnName = "inventoryId", nullable = true)
    private Inventory inventory;


    public InventoryNotice() {
    }

    public InventoryNotice(int noticeId, String department,
                           double orderQty, Date date, Date expDate, String orderHolder,
                           boolean state, Inventory inventory) {
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}//End Class

