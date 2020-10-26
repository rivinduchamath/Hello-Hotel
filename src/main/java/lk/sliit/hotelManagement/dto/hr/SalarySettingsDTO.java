package lk.sliit.hotelManagement.dto.hr;

import java.sql.Date;

public class SalarySettingsDTO {
    private int id;
    private double etf;
    private double epf;
    private double serviceCharge;
    private Date date;


    public SalarySettingsDTO(int id, double etf, double epf, double serviceCharge, Date date) {
        this.id = id;
        this.etf = etf;
        this.epf = epf;
        this.serviceCharge = serviceCharge;
        this.date = date;
    }

    public SalarySettingsDTO() {
    }

    public SalarySettingsDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalarySettingsDTO{" +
                "id=" + id +
                ", etf=" + etf +
                ", epf=" + epf +
                ", serviceCharge=" + serviceCharge +
                ", date=" + date +
                '}';
    }
}
