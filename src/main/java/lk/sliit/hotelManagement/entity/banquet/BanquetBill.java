package lk.sliit.hotelManagement.entity.banquet;

import javax.persistence.*;

@Entity
public class BanquetBill {
    @Id
    private String billId;
    private double total;
    private double foodPrice;
    private double otherPrices;
    private double advancePayment;


    public BanquetBill(String billId, double total, double foodPrice, double otherPrices, double advancePayment) {
        this.billId = billId;
        this.total = total;
        this.foodPrice = foodPrice;
        this.otherPrices = otherPrices;
        this.advancePayment = advancePayment;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public double getOtherPrices() {
        return otherPrices;
    }

    public void setOtherPrices(double otherPrices) {
        this.otherPrices = otherPrices;
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
