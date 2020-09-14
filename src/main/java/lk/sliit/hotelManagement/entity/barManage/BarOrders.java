package lk.sliit.hotelManagement.entity.barManage;

import lk.sliit.hotelManagement.entity.SuperEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
public class BarOrders implements SuperEntity {
    @Id
    private int orderId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int customerId;
    private int user;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<BarOrderDetails> orderDetails = new ArrayList<>();

    public BarOrders() {
    }



    public BarOrders(int id, Date date, int customerId, int user) {
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


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<BarOrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

}//End Class
