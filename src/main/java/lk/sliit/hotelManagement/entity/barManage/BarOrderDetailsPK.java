package lk.sliit.hotelManagement.entity.barManage;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BarOrderDetailsPK implements Serializable {

    private int orderId;
    private int productId;

    public BarOrderDetailsPK() {
    }

    public BarOrderDetailsPK(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

