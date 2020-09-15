package lk.sliit.hotelManagement.dto.manager;

import lk.sliit.hotelManagement.entity.hr.Attendance;
import lk.sliit.hotelManagement.entity.hr.Salary;

import java.sql.Date;
import java.util.List;

public class EmployeeDTO {
    private int userId;
    private String name;
    private String mobileNo;
    private String email;
    private String address;
    private String position;
    private String password;
    private Date dateOfBirth;
    private String gender;
    private double salary;
    private Date date;
    private String image;
    private int department ;
    private double otHours;
    private double totHours;




    public EmployeeDTO(int userId, String name, String mobileNo, String email
            , String address, String position, String password,
                       Date dateOfBirth, String gender, double salary, Date date,
                       String image, int department) {
        this.userId = userId;
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
        this.address = address;
        this.position = position;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.salary = salary;
        this.date = date;
        this.image = image;
        this.department = department;
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(int userId, String name, String mobileNo, String email,
                       String address, String position, String password, Date dateOfBirth,
                       String gender, double salary, Date date, String image, int department, double otHours, double totHours) {
        this.userId = userId;
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
        this.address = address;
        this.position = position;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.salary = salary;
        this.date = date;
        this.image = image;
        this.department = department;
        this.otHours = otHours;
        this.totHours = totHours;
    }

    public EmployeeDTO(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public double getOtHours() {
        return otHours;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    public double getTotHours() {
        return totHours;
    }

    public void setTotHours(int totHours) {
        this.totHours = totHours;
    }

    public EmployeeDTO(int userId) {
        this.userId = userId;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", date=" + date +
                ", image='" + image + '\'' +
                ", department=" + department +
                ", otHours=" + otHours +
                ", totHours=" + totHours +
                '}';
    }
}