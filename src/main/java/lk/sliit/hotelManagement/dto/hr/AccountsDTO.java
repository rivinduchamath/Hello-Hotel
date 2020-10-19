package lk.sliit.hotelManagement.dto.hr;

import java.sql.Date;

public class AccountsDTO {
    private int accountId;
    private String chequeNo;
    private double amount;
    private Date date;
    private int department;
    private String description;

    public AccountsDTO(int accountId, String chequeNo, double amount, Date date, int department, String description) {
        this.accountId = accountId;
        this.chequeNo = chequeNo;
        this.amount = amount;
        this.date = date;
        this.department = department;
        this.description = description;
    }

    public AccountsDTO() {
    }

    public AccountsDTO(int accountId) {
        this.accountId = accountId;
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

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AccountsDTO{" +
                "accountId=" + accountId +
                ", chequeNo=" + chequeNo +
                ", amount=" + amount +
                ", date=" + date +
                ", department=" + department +
                ", description='" + description + '\'' +
                '}';
    }
}
