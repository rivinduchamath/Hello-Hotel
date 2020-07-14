package lk.sliit.employeeManagement.entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class HouseKeeping implements SuperEntity {
    @Id
    private String roomId ;
    private String name;
    @Column(length = 1000)
    private String description;
    @Column(nullable = true)
    private double price;
    private String category;
    @Column(nullable = true)
    private double totalIncome;
    private String submittedBy;
    private String hrManagerId;
    private Date date;

    public HouseKeeping(String roomId, String name, String description,
                        double price, String category, double totalIncome,
                        String submittedBy, String hrManagerId, Date date) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.totalIncome = totalIncome;
        this.submittedBy = submittedBy;
        this.hrManagerId = hrManagerId;
        this.date = date;
    }

    public HouseKeeping() {
    }

    public String getHrManagerId() {
        return hrManagerId;
    }

    public void setHrManagerId(String hrManagerId) {
        this.hrManagerId = hrManagerId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}//End Class
