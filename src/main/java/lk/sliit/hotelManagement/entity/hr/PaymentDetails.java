package lk.sliit.hotelManagement.entity.hr;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PaymentDetails {
    @Id
    private int detailId;
    private String name;
    private double valuePrice;
    private Date date;

    public PaymentDetails(int detailId, String name, double valuePrice, Date date) {
        this.detailId = detailId;
        this.name = name;
        this.valuePrice = valuePrice;
        this.date = date;
    }

    public PaymentDetails() {
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValuePrice() {
        return valuePrice;
    }

    public void setValuePrice(double valuePrice) {
        this.valuePrice = valuePrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

