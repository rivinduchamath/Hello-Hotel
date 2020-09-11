package lk.sliit.hotelManagement.dto.hr;

import java.sql.Date;

public class CurrentBillDTO {
    private int billId;
    private double amount;
    private Date date;

    public CurrentBillDTO(int billId, double amount, Date date) {
        this.billId = billId;
        this.amount = amount;
        this.date = date;
    }

    public CurrentBillDTO() {
    }

    public CurrentBillDTO(int billId) {

    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
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

    @Override
    public String toString() {
        return "CurrentBillDTO{" +
                "billId='" + billId + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
