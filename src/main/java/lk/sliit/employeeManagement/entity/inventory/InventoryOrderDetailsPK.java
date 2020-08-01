package lk.sliit.employeeManagement.entity.inventory;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class InventoryOrderDetailsPK implements Serializable {

    private String inventoryId;
    private String orderId;

    public InventoryOrderDetailsPK(String inventoryId, String orderId) {
        this.inventoryId = inventoryId;
        this.orderId = orderId;
    }

    public InventoryOrderDetailsPK() {
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
