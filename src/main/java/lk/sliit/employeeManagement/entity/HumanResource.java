package lk.sliit.employeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class HumanResource implements SuperEntity {
    @Id
    private String houseID ;
    private String text;
    @Column(length = 1000)
    private String description;
    private Date date;

    public HumanResource(String houseID, String text, String description, Date date) {
        this.houseID = houseID;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public HumanResource() {
    }

    public String getBanquetId() {
        return houseID;
    }

    public void setBanquetId(String houseID) {
        this.houseID = houseID;
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
