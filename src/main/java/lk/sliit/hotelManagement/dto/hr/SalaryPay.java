package lk.sliit.hotelManagement.dto.hr;

import lk.sliit.hotelManagement.entity.manager.Employee;

import java.util.Date;

public class SalaryPay {
    private int id;
    private double basicSalary;
    private Date date;
    private double etf;
    private double epf;
    private double hours;
    private double otHours;
    private double salary;
    private double serviceCharge;
    private boolean state;
    private int employee;
    private String source;

    public SalaryPay(int id, double basicSalary, Date date, double etf, double epf,
                     double hours, double otHours, double salary, double serviceCharge,
                     boolean state, int employee) {
        this.id = id;
        this.basicSalary = basicSalary;
        this.date = date;
        this.etf = etf;
        this.epf = epf;
        this.hours = hours;
        this.otHours = otHours;
        this.salary = salary;
        this.serviceCharge = serviceCharge;
        this.state = state;
        this.employee = employee;
    }

    public SalaryPay() {
    }

    public SalaryPay( double basicSalary, Date date, double etf, double epf,
                     double hours, double otHours, double salary, double serviceCharge,
                     boolean state, int employee) {     this.basicSalary = basicSalary;
        this.date = date;
        this.etf = etf;
        this.epf = epf;
        this.hours = hours;
        this.otHours = otHours;
        this.salary = salary;
        this.serviceCharge = serviceCharge;
        this.state = state;
        this.employee = employee;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getOtHours() {
        return otHours;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }



    @Override
    public String toString() {
        return "SalaryPay{" +
                "id=" + id +
                ", basicSalary=" + basicSalary +
                ", date=" + date +
                ", etf=" + etf +
                ", epf=" + epf +
                ", hours=" + hours +
                ", otHours=" + otHours +
                ", salary=" + salary +
                ", serviceCharge=" + serviceCharge +
                ", state=" + state +
                ", employee=" + employee +
                '}';
    }
}
