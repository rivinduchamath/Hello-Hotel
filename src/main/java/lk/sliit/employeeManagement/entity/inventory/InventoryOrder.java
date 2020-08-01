package lk.sliit.employeeManagement.entity.inventory;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InventoryOrder {
    @Id
    private String orderId;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "supplier", referencedColumnName = "id", nullable = false)
    private Supplier supplier;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<InventoryOrderDetails> orderDetails = new ArrayList<>();

    public InventoryOrder(String orderId, Date date, Supplier supplier) {
        this.orderId = orderId;
        this.date = date;
        this.supplier = supplier;
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

    public List<InventoryOrderDetails> getOrderDetails() {
        return orderDetails;
    }

}
