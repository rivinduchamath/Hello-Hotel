package lk.sliit.employeeManagement.dto.beverage;

import lk.sliit.employeeManagement.entity.barManage.BarOrders;



public class BarBillDTO {
    private  String billId;
    private double discount;
    private String status;
    private double total;
    private String order;

    public BarBillDTO(String billId, double discount, String status, double total, String order) {
        this.billId = billId;
        this.discount = discount;
        this.status = status;
        this.total = total;
        this.order = order;
    }

    public BarBillDTO() {
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "BarBillDTO{" +
                "billId='" + billId + '\'' +
                ", discount=" + discount +
                ", status='" + status + '\'' +
                ", total=" + total +
                ", order='" + order + '\'' +
                '}';
    }
}
