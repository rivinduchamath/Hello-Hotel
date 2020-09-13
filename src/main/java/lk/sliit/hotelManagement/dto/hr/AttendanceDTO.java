package lk.sliit.hotelManagement.dto.hr;


import lk.sliit.hotelManagement.entity.hr.Department;

import java.util.Date;

public class AttendanceDTO {

    private int attendanceId;
    private double salary;
    private Date date;
    private String inTime;
    private String outTime;
    private double overtimeHours;
    private int employeeID;
    private String empName;
    private String position;
    private String pic;
    private String empDepartment;


    //Default Constructor
    public AttendanceDTO() {
    }


    //Constructor
    public AttendanceDTO(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public AttendanceDTO(int attendanceId, Date date, String inTime, String outTime, double overtimeHours, int userId, String name, String position,String pic) {
        this.attendanceId = attendanceId;
        this.salary = salary;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = userId;
        this.empName = name;
        this.position = position;
        this.pic = pic;
    }


    public AttendanceDTO(int attendanceId, Date date, String inTime,
                         String outTime, double overtimeHours, int userId,
                         String name, String position, String image, String departmentName) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = userId;
        this.empName = name;
        this.position = position;
        this.pic = image;
        this.empDepartment = departmentName;
    }


    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }



    // Override To String
    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "attendanceId=" + attendanceId +
                ", salary=" + salary +
                ", date=" + date +
                ", inTime='" + inTime + '\'' +
                ", outTime='" + outTime + '\'' +
                ", overtimeHours=" + overtimeHours +
                ", employeeID=" + employeeID +
                '}';
    }//End To String
}//End Class Attendance DTO


