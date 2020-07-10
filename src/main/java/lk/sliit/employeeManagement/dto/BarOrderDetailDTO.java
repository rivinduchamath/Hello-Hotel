package lk.sliit.employeeManagement.dto;

import java.sql.Date;


public class BarOrderDetailDTO {

    private String itemCode;
    private String itemName;
    private double itemPrice;
    private double qty;
    private double totalPrice;

    public BarOrderDetailDTO(String itemCode, String itemName, double itemPrice, double qty, double totalPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }

    public BarOrderDetailDTO() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BarOrderDetailDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemPrice=" + itemPrice +
                ", qty=" + qty +
                '}';
    }
}//End Class
