package lk.sliit.employeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Kitchen implements SuperEntity {
    @Id
    private String kitchenId ;
    private String text;
    @Column(length = 1000)
    private String description;
    private Date date;

    public Kitchen(String kitchenId, String text, String description, Date date) {
        this.kitchenId = kitchenId;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public Kitchen() {
    }

    public String getBanquetId() {
        return kitchenId;
    }

    public void setBanquetId(String kitchenId) {
        this.kitchenId = kitchenId;
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

