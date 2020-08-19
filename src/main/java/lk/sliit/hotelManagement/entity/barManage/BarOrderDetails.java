package lk.sliit.hotelManagement.entity.barManage;

import lk.sliit.hotelManagement.entity.SuperEntity;
import lk.sliit.hotelManagement.entity.inventory.Inventory;

import javax.persistence.*;

@Entity
public class BarOrderDetails implements SuperEntity {

    @EmbeddedId
    private BarOrderDetailsPK orderDetailPK;
    private double quantity;
    private double unitePrice;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="orderId",referencedColumnName = "orderId", insertable = false, updatable = false)
    private BarOrders order;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="productId",referencedColumnName = "inventoryId", insertable = false, updatable = false)
    private Inventory inventory;

    public BarOrderDetails() {
    }

    public BarOrderDetails(BarOrderDetailsPK orderDetailPK, double quantity, double unitePrice) {
        this.orderDetailPK = orderDetailPK;
        this.quantity = quantity;
        this.unitePrice = unitePrice;

    }


    public BarOrderDetails(String orderId, String productId, double quantity, double unitePrice) {
        this.orderDetailPK = new BarOrderDetailsPK(orderId,productId);
        this.quantity = quantity;
        this.unitePrice = unitePrice;

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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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
