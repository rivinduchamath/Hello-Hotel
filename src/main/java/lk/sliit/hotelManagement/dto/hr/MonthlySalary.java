package lk.sliit.hotelManagement.dto.hr;

import java.util.List;

public class MonthlySalary {

    private int userId;
    private String name;
    private double salary;
    private double totOT;

    public MonthlySalary(int userId, String name, double salary, double totOT) {
        this.userId = userId;
        this.name = name;
        this.salary = salary;
        this.totOT = totOT;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTotOT() {
        return totOT;
    }

    public void setTotOT(double totOT) {
        this.totOT = totOT;
    }

    @Override
    public String toString() {
        return "MonthlySalary{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", totOT=" + totOT +
                '}';
    }
}
