package lk.sliit.employeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Inventory implements SuperEntity {
    @Id
    private String inventoryId ;
    private String text;
    @Column(length = 1000)
    private String description;
    private Date date;

    public Inventory(String inventoryId, String text, String description, Date date) {
        this.inventoryId = inventoryId;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public Inventory() {
    }

    public String getBanquetId() {
        return inventoryId;
    }

    public void setBanquetId(String inventoryId) {
        this.inventoryId = inventoryId;
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

