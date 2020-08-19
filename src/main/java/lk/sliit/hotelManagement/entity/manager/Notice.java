package lk.sliit.hotelManagement.entity.manager;


import lk.sliit.hotelManagement.entity.SuperEntity;
import lk.sliit.hotelManagement.entity.hr.Department;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Notice implements SuperEntity {

    @Id
    private String noticeId ;
    private String title;
    @Column(length = 1000)
    private String description;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="departmentId",referencedColumnName = "departmentId")
    private Department department;

    public Notice(String noticeId, String title, String description, Date date, Department department) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}//End Class
