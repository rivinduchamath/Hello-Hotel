package lk.sliit.employeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Manage implements SuperEntity {

    @Id
    private String manageID ;
    private String title;
    @Column(length = 1000)
    private String description;
    private Date date;

    public Manage(String manageID, String title, String description, Date date) {
        this.manageID = manageID;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Manage() {
    }

    public String getNoticeId() {
        return manageID;
    }

    public void setNoticeId(String manageID) {
        this.manageID = manageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
