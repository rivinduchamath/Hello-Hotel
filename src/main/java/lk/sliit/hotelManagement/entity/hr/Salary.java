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
    private double otHours;
    @Column(nullable = true)
    private double hours;
    private boolean state;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "employeeID", referencedColumnName = "userId", nullable = true)
    private Employee employeeID;

    public Salary() {}

    public Salary(int salaryId, double otHours,
                  double hours, boolean state, Date date, Employee employeeID) {
        this.salaryId = salaryId;

        this.otHours = otHours;
        this.hours = hours;

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
