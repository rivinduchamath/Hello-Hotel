package lk.sliit.employeeManagement.entity.barManage;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BarOrderDetailsPK implements Serializable {

    private String orderId;
    private String productId;

    public BarOrderDetailsPK() {
    }

    public BarOrderDetailsPK(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "BarOrderDetailsPK{" +
                "orderId=" + orderId +
                ", productId='" + productId + '\'' +
                '}';
    }
}

