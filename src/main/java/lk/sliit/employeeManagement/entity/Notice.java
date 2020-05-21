package lk.sliit.employeeManagement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Notice implements SuperEntity{

    @Id
    private String noticeId ;
    private String title;
    @Column(length = 1000)
    private String description;
    private Date date;

    public Notice(String noticeId, String title, String description, Date date) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Notice() {
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
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
