package lk.sliit.employeeManagement.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Banquet implements SuperEntity {
    @Id
    private String banquetId ;
    private String text;
    @Column(length = 1000)
    private String description;
    private Date date;

    public Banquet(String banquetId, String text, String description, Date date) {
        this.banquetId = banquetId;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public Banquet() {
    }

    public String getBanquetId() {
        return banquetId;
    }

    public void setBanquetId(String banquetId) {
        this.banquetId = banquetId;
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
