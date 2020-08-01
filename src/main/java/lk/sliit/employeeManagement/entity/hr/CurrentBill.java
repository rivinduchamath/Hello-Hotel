package lk.sliit.employeeManagement.entity.hr;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class CurrentBill {
    @Id
    private String billId;
    private double amount;
    private Date date;

    public CurrentBill(String billId, double amount, Date date) {
        this.billId = billId;
        this.amount = amount;
        this.date = date;
    }

    public CurrentBill() {
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
