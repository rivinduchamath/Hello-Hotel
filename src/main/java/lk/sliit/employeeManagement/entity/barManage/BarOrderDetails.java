package lk.sliit.employeeManagement.entity.barManage;

import lk.sliit.employeeManagement.entity.SuperEntity;
import lk.sliit.employeeManagement.entity.inventory.Inventory;

import javax.persistence.*;

@Entity
public class BarOrderDetails implements SuperEntity {

    @EmbeddedId
    private BarOrderDetailsPK orderDetailPK;
    private int quantity;
    private double unitePrice;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="orderId",referencedColumnName = "orderId", insertable = false, updatable = false)
    private BarOrders order;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="inventory",referencedColumnName = "inventoryId", insertable = false, updatable = false)
    private Inventory inventory;

    public BarOrderDetails() {
    }

    public BarOrderDetails(BarOrderDetailsPK orderDetailPK, int quantity, double unitePrice, BarOrders order,Inventory inventory) {
        this.orderDetailPK = orderDetailPK;
        this.quantity = quantity;
        this.unitePrice = unitePrice;
        this.order = order;
        this.inventory = inventory;
    }


    public BarOrderDetails(String orderId, String productId, int quantity, double unitePrice, BarOrders order,Inventory inventory) {
        this.orderDetailPK = new BarOrderDetailsPK(orderId,productId);
        this.quantity = quantity;
        this.unitePrice = unitePrice;
        this.order = order;
        this.inventory = inventory;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public BarOrderDetailsPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(BarOrderDetailsPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public BarOrders getOrder() {
        return order;
    }

    public void setOrder(BarOrders order) {
        this.order = order;
    }


}
