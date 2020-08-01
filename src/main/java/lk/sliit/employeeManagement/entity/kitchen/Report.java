package lk.sliit.employeeManagement.entity.kitchen;

import lk.sliit.employeeManagement.entity.kitchen.FoodItem;
import javax.persistence.*;

@Entity
public class Report {
    @Id
    private String reportId;
    private double quantity;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="foodItem",referencedColumnName = "itemId", insertable = false, updatable = false)
    private FoodItem foodItem;


    public Report(String reportId, double quantity) {
        this.reportId = reportId;
        this.quantity = quantity;
    }

    public Report() {
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
