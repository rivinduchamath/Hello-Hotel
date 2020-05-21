package lk.sliit.employeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class FoodAndBeverage implements SuperEntity {
    @Id
    private String foodId ;
    private String text;
    @Column(length = 1000)
    private String description;
    private Date date;

    public FoodAndBeverage(String foodId, String text, String description, Date date) {
        this.foodId = foodId;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public FoodAndBeverage() {
    }

    public String getBanquetId() {
        return foodId;
    }

    public void setBanquetId(String foodId) {
        this.foodId = foodId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}//End Class
