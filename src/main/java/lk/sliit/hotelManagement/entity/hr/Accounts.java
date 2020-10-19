package lk.sliit.hotelManagement.entity.hr;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Accounts {
    @Id
    private int accountId;
    private String chequeNo;
    private double amount;
    private Date date;
    private String description;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department department;

    public Accounts(int accountId, String chequeNo, double amount, Date date, String description, Department department) {
        this.accountId = accountId;
        this.chequeNo = chequeNo;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.department = department;
    }

    public Accounts() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
