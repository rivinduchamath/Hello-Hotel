package lk.sliit.hotelManagement.dto.hr;


import java.util.Date;

public class AttendanceDTO {
    private String attendanceId;
    private Date date;
    private String inTime;
    private String outTime;
    private double overtimeHours;
    private String employeeID;

    public AttendanceDTO(String attendanceId, Date date, String inTime, String outTime, double overtimeHours, String employeeID) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = employeeID;
    }

    public AttendanceDTO() {
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "attendanceId='" + attendanceId + '\'' +
                ", date=" + date +
                ", inTime='" + inTime + '\'' +
                ", outTime='" + outTime + '\'' +
                ", overtimeHours=" + overtimeHours +
                ", employeeID='" + employeeID + '\'' +
                '}';
    }
}
