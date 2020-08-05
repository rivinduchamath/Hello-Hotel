package lk.sliit.hotelManagement.dto.hr;

import java.sql.Date;

public class CurrentBillDTO {
    private String billId;
    private double amount;
    private Date date;

    public CurrentBillDTO(String billId, double amount, Date date) {
        this.billId = billId;
        this.amount = amount;
        this.date = date;
    }

    public CurrentBillDTO() {
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

    @Override
    public String toString() {
        return "CurrentBillDTO{" +
                "billId='" + billId + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
