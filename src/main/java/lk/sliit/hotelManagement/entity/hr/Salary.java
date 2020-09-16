package lk.sliit.hotelManagement.entity.hr;

import lk.sliit.hotelManagement.entity.SuperEntity;
import lk.sliit.hotelManagement.entity.manager.Employee;
import javax.persistence.*;
import java.util.Date;


@Entity
public class Salary implements SuperEntity {

    @Id
    private int salaryId;
    @Column(nullable = true)
    private double basicSalary;
    @Column(nullable = true)
    private double etf;
    @Column(nullable = true)
    private double epf;
    @Column(nullable = true)
    private double serviceCharge;
    @Column(nullable = true)
    private double otHours;
    @Column(nullable = true)
    private double hours;
    @Column(nullable = true)
    private double salary;
    private boolean state;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "employeeID", referencedColumnName = "userId", nullable = true)
    private Employee employeeID;

    public Salary() {}

    public Salary(int salaryId, double basicSalary, double etf, double epf, double serviceCharge, double otHours,
                  double hours, double salary, boolean state, Date date, Employee employeeID) {
        this.salaryId = salaryId;
        this.basicSalary = basicSalary;
        this.etf = etf;
        this.epf = epf;
        this.serviceCharge = serviceCharge;
        this.otHours = otHours;
        this.hours = hours;
        this.salary = salary;
        this.state = state;
        this.date = date;
        this.employeeID = employeeID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
