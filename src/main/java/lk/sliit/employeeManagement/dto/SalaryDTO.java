package lk.sliit.employeeManagement.dto;

import java.sql.Date;

public class SalaryDTO {


    private String SalaryId;
    private double basicSalary;
    private double otHours;
    private double otRate;
    private double bonus;
    private double incomeTax;
    private Date date;

    public SalaryDTO() {
    }

    public SalaryDTO(String salaryId, double basicSalary, double otHours, double otRate, double bonus, double incomeTax) {
        SalaryId = salaryId;
        this.basicSalary = basicSalary;
        this.otHours = otHours;
        this.otRate = otRate;
        this.bonus = bonus;
        this.incomeTax = incomeTax;
    }

    public String getSalaryId() {
        return SalaryId;
    }

    public void setSalaryId(String salaryId) {
        SalaryId = salaryId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getOtHours() {
        return otHours;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    public double getOtRate() {
        return otRate;
    }

    public void setOtRate(double otRate) {
        this.otRate = otRate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "SalaryId='" + SalaryId + '\'' +
                ", basicSalary=" + basicSalary +
                ", otHours=" + otHours +
                ", otRate=" + otRate +
                ", bonus=" + bonus +
                ", incomeTax=" + incomeTax +
                '}';
    }
}
