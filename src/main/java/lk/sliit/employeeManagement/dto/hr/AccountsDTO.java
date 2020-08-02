package lk.sliit.employeeManagement.dto.hr;

import java.sql.Date;

public class AccountsDTO {
    private String accountId;
    private double expenses;
    private double income;
    private Date date;
    private String department;

    public AccountsDTO(String accountId, double expenses, double income, Date date, String department) {
        this.accountId = accountId;
        this.expenses = expenses;
        this.income = income;
        this.date = date;
        this.department = department;
    }

    public AccountsDTO() {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "AccountsDTO{" +
                "accountId='" + accountId + '\'' +
                ", expenses=" + expenses +
                ", income=" + income +
                ", date=" + date +
                ", department='" + department + '\'' +
                '}';
    }
}
