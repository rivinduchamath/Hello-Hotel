package lk.sliit.hotelManagement.entity.inventory;

import lk.sliit.hotelManagement.dto.inventory.SupplierDTO;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class InventoryOrder {
    @Id
    private String orderId;
    private Date date;
    private double price;
    private double quantity;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "supplier", referencedColumnName = "id", nullable = false)
    private Supplier supplier;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "inventory", referencedColumnName = "inventoryId", nullable = false)
    private Inventory inventory;

    public InventoryOrder(String orderId, Date date, double price, double quantity, Supplier supplier, Inventory inventory) {
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.inventory = inventory;
    }

    public InventoryOrder() {
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }



}
