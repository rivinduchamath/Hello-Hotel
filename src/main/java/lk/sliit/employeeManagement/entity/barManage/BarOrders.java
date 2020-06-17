package lk.sliit.employeeManagement.entity.barManage;

import lk.sliit.employeeManagement.entity.SuperEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
public class BarOrders implements SuperEntity {
    @Id
    private String orderId;
    private Date date;
    private double price;
    private String customerId;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<BarOrderDetails> orderDetails = new ArrayList<>();

    public BarOrders() {
    }

    public BarOrders(String orderId, Date date, double price, String customerId) {
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.customerId = customerId;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<BarOrderDetails> getOrderDetails() {
        return orderDetails;
    }

    @Override
    public String toString() {
        return "BarOrders{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", customerId='" + customerId + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}//End Class
