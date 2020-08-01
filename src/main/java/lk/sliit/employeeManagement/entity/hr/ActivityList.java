package lk.sliit.employeeManagement.entity.hr;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Entity
public class ActivityList {

    @Id
    private String activityId;
    @Temporal(TemporalType.TIME)
    private Date inTime;
    @Temporal(TemporalType.TIME)
    private Date outTime;
    private Date date;
    private String employeeId;
    private String departmentId;

    public ActivityList() {
    }

    public ActivityList(String activityId, Date inTime, Date outTime, Date date, String employeeId, String departmentId) {
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

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
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
