package lk.sliit.employeeManagement.dto.hr;


import java.util.Date;

public class ActivityListDTO {
    private String activityId;
    private Date inTime;
    private Date outTime;
    private Date date;
    private String employeeId;
    private String departmentId;

    public ActivityListDTO(String activityId, Date inTime, Date outTime, Date date, String employeeId, String departmentId) {
        this.activityId = activityId;
        this.inTime = inTime;
        this.outTime = outTime;
        this.date = date;
        this.employeeId = employeeId;
        this.departmentId = departmentId;
    }

    public ActivityListDTO() {
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

    @Override
    public String toString() {
        return "ActivityListDTO{" +
                "activityId='" + activityId + '\'' +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", date=" + date +
                ", employeeId='" + employeeId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
