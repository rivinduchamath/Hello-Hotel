package lk.sliit.hotelManagement.dto.inventory;


import java.sql.Date;

public class InventoryOrderDTO {
    private int orderId;
    private Date date;
    private double price;
    private double quantity;
    private int supplierId;
    private String supplier;
    private int inventoryId;
    private String inventory;
    public InventoryOrderDTO(int orderId, Date date, double price, double quantity, String supplier, String inventory) {
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.inventory = inventory;
    }

    public InventoryOrderDTO(int orderId, Date date, double price,
                             double quantity, int supplierId, String supplier, int inventoryId, String inventory) {
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.supplierId = supplierId;
        this.supplier = supplier;
        this.inventoryId = inventoryId;
        this.inventory = inventory;
    }

    public InventoryOrderDTO() {
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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
                "orderId=" + orderId +
                ", date=" + date +
                ", price=" + price +
                ", quantity=" + quantity +
                ", supplierId=" + supplierId +
                ", supplier='" + supplier + '\'' +
                ", inventoryId=" + inventoryId +
                ", inventory='" + inventory + '\'' +
                '}';
    }
}
