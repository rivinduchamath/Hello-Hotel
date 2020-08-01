package lk.sliit.employeeManagement.entity.manager;


import lk.sliit.employeeManagement.entity.SuperEntity;
import lk.sliit.employeeManagement.entity.barManage.BarOrders;
import lk.sliit.employeeManagement.entity.hr.Department;

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
    @JoinColumn(name="departmentId",referencedColumnName = "departmentId", insertable = false, updatable = false)
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}//End Class
