package lk.sliit.hotelManagement.entity.hr;

import lk.sliit.hotelManagement.entity.manager.Employee;
import javax.persistence.*;
import java.util.Date;


@Entity
public class Attendance  {

    @Id
    private int attendanceId;
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date date;
    private double salary;
    private String inTime;
    private String outTime;
    @Column(columnDefinition = "double default 0")
    private double overtimeHours;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = true)
    private Employee employeeID;

    public Attendance(int attendanceId, Date date, double salary, String inTime,
                      String outTime, double overtimeHours, Employee employeeID) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.salary = salary;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = employeeID;
    }

    public Attendance() {}

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
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

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }


}
