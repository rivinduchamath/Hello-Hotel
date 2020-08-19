package lk.sliit.hotelManagement.entity.barManage;

import lk.sliit.hotelManagement.entity.SuperEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
public class BarOrders implements SuperEntity {
    @Id
    private String orderId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String customerId;
    private String user;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<BarOrderDetails> orderDetails = new ArrayList<>();

    public BarOrders() {
    }

    public BarOrders(String orderId, Date date,  String customerId, String user, List<BarOrderDetails> orderDetails) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.user = user;
        this.orderDetails = orderDetails;
    }

    public BarOrders(String id, Date date, String customerId, String user) {
        this.orderId = id;
        this.date = date;
        this.customerId = customerId;
        this.user = user;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}//End Class
