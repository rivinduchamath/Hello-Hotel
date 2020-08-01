package lk.sliit.employeeManagement.entity.hr;

import lk.sliit.employeeManagement.entity.barManage.BarOrders;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Accounts {
    @Id
    private String accountId;
    private double expenses;
    private double income;
    private Date date;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    private Department department;

    public Accounts(String accountId, double expenses, double income, Date date, Department department) {
        this.accountId = accountId;
        this.expenses = expenses;
        this.income = income;
        this.date = date;
        this.department = department;
    }

    public Accounts() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
