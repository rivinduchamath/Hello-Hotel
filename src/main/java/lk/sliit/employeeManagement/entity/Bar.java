package lk.sliit.employeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Bar implements SuperEntity {
    @Id
    private String barId ;
    private String text;
    @Column(length = 1000)
    private String description;
    private Date date;

    public Bar(String barId, String text, String description, Date date) {
        this.barId = barId;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public Bar() {
    }

    public String getBanquetId() {
        return barId;
    }

    public void setBanquetId(String barId) {
        this.barId = barId;
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
