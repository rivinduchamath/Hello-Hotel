package lk.sliit.employeeManagement.entity.barManage;

import lk.sliit.employeeManagement.entity.SuperEntity;

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
    @JoinColumn(name="stockId",referencedColumnName = "productId", insertable = false, updatable = false)
    private BarStock barStock;

    public BarOrderDetails() {
    }

    public BarOrderDetails(BarOrderDetailsPK orderDetailPK, int quantity, double unitePrice, BarOrders order,BarStock barStock) {
        this.orderDetailPK = orderDetailPK;
        this.quantity = quantity;
        this.unitePrice = unitePrice;
        this.order = order;
        this.barStock = barStock;
    }


    public BarOrderDetails(String orderId, String productId, int quantity, double unitePrice, BarOrders order,BarStock barStock) {
        this.orderDetailPK = new BarOrderDetailsPK(orderId,productId);
        this.quantity = quantity;
        this.unitePrice = unitePrice;
        this.order = order;
        this.barStock = barStock;
    }


    public BarStock getBarStock() {
        return barStock;
    }

    public void setBarStock(BarStock barStock) {
        this.barStock = barStock;
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

    @Override
    public String toString() {
        return "BarOrderDetails{" +
                "orderDetailPK=" + orderDetailPK +
                ", quantity=" + quantity +
                ", unitePrice=" + unitePrice +
                ", order=" + order +
                '}';
    }
}
