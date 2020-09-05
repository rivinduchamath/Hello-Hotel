package lk.sliit.hotelManagement.dto.banquet;

public class BanquetBillDTO {
    private String billId;
    private double total;
    private double foodPrice;
    private double otherPrices;
    private double advancePayment;

    public BanquetBillDTO() {
    }

    public BanquetBillDTO(String billId, double total, double foodPrice, double otherPrices, double advancePayment) {
        this.billId = billId;
        this.total = total;
        this.foodPrice = foodPrice;
        this.otherPrices = otherPrices;
        this.advancePayment = advancePayment;
    }

    public BanquetBillDTO(String billId) {
        this.billId = billId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
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

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BanquetBillDTO{" +
                "billId='" + billId + '\'' +
                ", total=" + total +
                ", foodPrice=" + foodPrice +
                ", otherPrices=" + otherPrices +
                ", advancePayment=" + advancePayment +
                '}';
    }
}
