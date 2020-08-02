package lk.sliit.employeeManagement.dto.inventory;


import java.sql.Date;

public class InventoryOrderDTO {
    private String orderId;
    private Date date;
    private double price;
    private double quantity;
    private String supplier;
    private String inventory;

    public InventoryOrderDTO(String orderId, Date date, double price, double quantity, String supplier, String inventory) {
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.inventory = inventory;
    }

    public InventoryOrderDTO() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "InventoryOrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", quantity=" + quantity +
                ", supplier='" + supplier + '\'' +
                ", inventory='" + inventory + '\'' +
                '}';
    }
}
