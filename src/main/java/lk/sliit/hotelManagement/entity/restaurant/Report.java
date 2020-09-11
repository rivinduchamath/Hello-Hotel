package lk.sliit.hotelManagement.entity.restaurant;

import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Report {
    @Id
    private int reportId;
    private double quantity;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="foodItem",referencedColumnName = "itemId")
    private FoodItem foodItem;


    public Report(int reportId, double quantity, Date date, FoodItem foodItem) {
        this.reportId = reportId;
        this.quantity = quantity;
        this.date = date;
        this.foodItem = foodItem;
    }

    public Report() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
