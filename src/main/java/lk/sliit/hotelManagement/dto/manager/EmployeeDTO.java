package lk.sliit.hotelManagement.dto.manager;

import lk.sliit.hotelManagement.entity.hr.Attendance;
import lk.sliit.hotelManagement.entity.hr.Salary;

import java.sql.Date;
import java.util.List;

public class EmployeeDTO {
    private String userId;
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
    private String department ;

    private List<Attendance> attendance;
    private List<Salary> salaries;


    public EmployeeDTO(String userId, String name, String mobileNo, String email
            , String address, String position, String password,
                       Date dateOfBirth, String gender, double salary, Date date,
                       String image, String department) {
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

    public EmployeeDTO(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
                "userId='" + userId + '\'' +
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
                ", attendance=" + attendance +
                ", salaries=" + salaries +
                '}';
    }
}