package lk.sliit.employeeManagement.entity.hr;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;

@Entity
public class ActivityList {

    @Id
    private String activityId;
    private String inTime;
    private String outTime;
    private Date date;
    private String employeeId;
    private String departmentId;

    public ActivityList() {
    }

    public ActivityList(String activityId, String inTime, String outTime, Date date, String employeeId, String departmentId) {
        this.activityId = activityId;
        this.inTime = inTime;
        this.outTime = outTime;
        this.date = date;
        this.employeeId = employeeId;
        this.departmentId = departmentId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
