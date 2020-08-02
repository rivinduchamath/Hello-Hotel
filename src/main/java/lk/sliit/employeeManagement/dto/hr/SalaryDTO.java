package lk.sliit.employeeManagement.dto.hr;

import lk.sliit.employeeManagement.entity.manager.Employee;

public class SalaryDTO {
    private String salaryId;
    private double basicSalary;
    private double etf;
    private double epf;
    private double serviceCharge;
    private double otHours;
    private double hours;
    private double salary;
    private String employeeID;

    public SalaryDTO() {
    }

    public SalaryDTO(String salaryId, double basicSalary, double etf,
                     double epf, double serviceCharge, double otHours, double hours,
                     double salary, String employeeID) {
        this.salaryId = salaryId;
        this.basicSalary = basicSalary;
        this.etf = etf;
        this.epf = epf;
        this.serviceCharge = serviceCharge;
        this.otHours = otHours;
        this.hours = hours;
        this.salary = salary;
        this.employeeID = employeeID;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salaryId='" + salaryId + '\'' +
                ", basicSalary=" + basicSalary +
                ", etf=" + etf +
                ", epf=" + epf +
                ", serviceCharge=" + serviceCharge +
                ", otHours=" + otHours +
                ", hours=" + hours +
                ", salary=" + salary +
                ", employeeID='" + employeeID + '\'' +
                '}';
    }
}
