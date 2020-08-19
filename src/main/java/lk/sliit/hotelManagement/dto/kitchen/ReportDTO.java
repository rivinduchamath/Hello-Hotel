package lk.sliit.hotelManagement.dto.kitchen;

import java.sql.Date;

public class ReportDTO {
    private String reportId;
    private double quantity;
    private Date date;
    private String foodItem;

    public ReportDTO(String reportId, double quantity, Date date, String foodItem) {
        this.reportId = reportId;
        this.quantity = quantity;
        this.date = date;
        this.foodItem = foodItem;
    }

    public ReportDTO() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "reportId='" + reportId + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", foodItem='" + foodItem + '\'' +
                '}';
    }
}
