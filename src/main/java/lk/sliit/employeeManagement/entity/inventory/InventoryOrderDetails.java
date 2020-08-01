package lk.sliit.employeeManagement.entity.inventory;

import javax.persistence.*;

@Entity
public class InventoryOrderDetails {
    @Id
    private InventoryOrderDetailsPK inventoryOrderDetailsPK;
     private double price;
     private double quantity;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="orderId",referencedColumnName = "orderId", insertable = false, updatable = false)
    private InventoryOrder order;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="item_code",referencedColumnName = "inventoryId",insertable = false, updatable = false)
    private Inventory item;

    public InventoryOrderDetails() {
    }

    public InventoryOrderDetails(InventoryOrderDetailsPK inventoryOrderDetailsPK, double price, double quantity) {
        this.inventoryOrderDetailsPK = inventoryOrderDetailsPK;
        this.price = price;
        this.quantity = quantity;

    }
    public InventoryOrderDetails(String inventoryId, String orderId, double price, double quantity) {
        this.inventoryOrderDetailsPK = new InventoryOrderDetailsPK(inventoryId,orderId);
        this.price = price;
        this.quantity = quantity;
    }

    public InventoryOrderDetailsPK getInventoryOrderDetailsPK() {
        return inventoryOrderDetailsPK;
    }

    public void setInventoryOrderDetailsPK(InventoryOrderDetailsPK inventoryOrderDetailsPK) {
        this.inventoryOrderDetailsPK = inventoryOrderDetailsPK;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public InventoryOrder getOrder() {
        return order;
    }

    public void setOrder(InventoryOrder order) {
        this.order = order;
    }

    public Inventory getItem() {
        return item;
    }

    public void setItem(Inventory item) {
        this.item = item;
    }
}
