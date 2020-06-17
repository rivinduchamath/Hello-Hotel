package lk.sliit.employeeManagement.entity.barManage;

import javax.persistence.*;

@Entity
public class BarBill {

    @Id
    private  String billId;
    private double discount;
    private String status;
    private double total;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="barOrder_Id",referencedColumnName = "orderId", insertable = false, updatable = false)
    private BarOrders order;

    public BarBill(String billId, double discount, String status, double total) {
        this.billId = billId;
        this.discount = discount;
        this.status = status;
        this.total = total;
    }

    public BarBill() {
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public BarOrders getOrder() {
        return order;
    }

    public void setOrder(BarOrders order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "BarBill{" +
                "billId='" + billId + '\'' +
                ", discount=" + discount +
                ", status='" + status + '\'' +
                ", total=" + total +
                ", order=" + order +
                '}';
    }
}
