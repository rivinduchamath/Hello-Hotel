package lk.sliit.employeeManagement.dto;

import java.sql.Date;

public class AttendanceDTO {


    private String attendanceId;
    private double salary;
    private Date date;
    private String inTime;
    private String outTime;
    private double overtimeHours;



    public AttendanceDTO() {}

    public AttendanceDTO(String attendanceId, double salary, Date date,
                       String inTime, String outTime, double overtimeHours) {
        this.attendanceId = attendanceId;
        this.salary = salary;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;

    }


    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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




}
