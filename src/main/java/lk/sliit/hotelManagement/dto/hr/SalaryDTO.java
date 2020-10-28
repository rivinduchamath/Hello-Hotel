package lk.sliit.hotelManagement.dto.hr;

import lk.sliit.hotelManagement.entity.manager.Employee;

import java.util.Date;

public class SalaryDTO {
    private int salaryId;
    private double basicSalary;
    private double etf;
    private double epf;
    private double serviceCharge;
    private double otHours;
    private double hours;
    private double salary;
    private int employeeID;
    private String  employeeName;
    boolean state;
    Date date;
    private String  image;

    private String source;


    public SalaryDTO() {
    }

    public SalaryDTO(int salaryId, double basicSalary, double etf, double epf, double serviceCharge, double otHours,
                     double hours, double salary, int employeeID, String employeeName, String image) {
        this.salaryId = salaryId;
        this.basicSalary = basicSalary;
        this.etf = etf;
        this.epf = epf;
        this.serviceCharge = serviceCharge;
        this.otHours = otHours;
        this.hours = hours;
        this.salary = salary;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.image = image;
    }

    public SalaryDTO(int salaryId) {
        this.salaryId = salaryId;
    }

    public SalaryDTO(int salaryId, double otHours, double hours, int userId, String name, String image) {
        this.salaryId = salaryId;
        this.employeeName = name;
        this.otHours = otHours;
        this.hours = hours;
        this.image = image;
        this.employeeID = userId;
    }

    public SalaryDTO(int salaryId, double otHours, double hours, int userId) {
        this.salaryId = salaryId;
        this.otHours = otHours;
        this.hours = hours;
        this.employeeID = userId;
    }

    public SalaryDTO(int salaryId, double otHours, double hours, boolean state, Date date, int employeeID) {
        this.salaryId = salaryId;
        this.otHours = otHours;
        this.state =state;
        this.hours = hours;
        this.date =date;
        this.employeeID = employeeID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getEtf() {
        return etf;
    }

    public void setEtf(double etf) {
        this.etf = etf;
    }

    public double getEpf() {
        return epf;
    }

    public void setEpf(double epf) {
        this.epf = epf;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getOtHours() {
        return otHours;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salaryId=" + salaryId +
                ", basicSalary=" + basicSalary +
                ", etf=" + etf +
                ", epf=" + epf +
                ", serviceCharge=" + serviceCharge +
                ", otHours=" + otHours +
                ", hours=" + hours +
                ", salary=" + salary +
                ", employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", state=" + state +
                ", date=" + date +
                ", image='" + image + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
