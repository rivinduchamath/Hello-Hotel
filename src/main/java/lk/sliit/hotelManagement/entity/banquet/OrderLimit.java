package lk.sliit.hotelManagement.entity.banquet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class OrderLimit {
    @Id
    private String limitId;
    private String limitName;
    private double orderLimit;

    public OrderLimit(String limitId, String limitName, double orderLimit) {
        this.limitId = limitId;
        this.limitName = limitName;
        this.orderLimit = orderLimit;
    }

    public OrderLimit() {
    }


    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId;
    }

    public String getLimitName() {
        return limitName;
    }

    public void setLimitName(String limitName) {
        this.limitName = limitName;
    }

    public double getOrderLimit() {
        return orderLimit;
    }

    public void setOrderLimit(double orderLimit) {
        this.orderLimit = orderLimit;
    }
}
