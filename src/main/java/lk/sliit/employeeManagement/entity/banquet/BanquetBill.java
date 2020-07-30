package lk.sliit.employeeManagement.entity.banquet;

import lk.sliit.employeeManagement.entity.restaurant.OnlineCustomer;

import javax.persistence.*;

@Entity
public class BanquetBill {
    @Id
    private String billId;
    private double total;
    private double advancePayment;


    public BanquetBill(String billId, double total, double advancePayment) {
        this.billId = billId;
        this.total = total;
        this.advancePayment = advancePayment;
    }

    public BanquetBill() {
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }


}
